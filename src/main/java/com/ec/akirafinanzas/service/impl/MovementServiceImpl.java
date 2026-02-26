package com.ec.akirafinanzas.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.error.UnauthorizedException;
import com.ec.akirafinanzas.model.dto.movement.CreateMovementRequestDTO;
import com.ec.akirafinanzas.model.dto.movement.MovementResponseDTO;
import com.ec.akirafinanzas.model.entity.Account;
import com.ec.akirafinanzas.model.entity.Category;
import com.ec.akirafinanzas.model.entity.Movement;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.model.mapper.MovementMapper;
import com.ec.akirafinanzas.repository.AccountRepository;
import com.ec.akirafinanzas.repository.CategoryRepository;
import com.ec.akirafinanzas.repository.MovementRepository;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.service.MovementService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MovementServiceImpl implements MovementService {

        private final MovementRepository movementRepository;
        private final UserRepository userRepository;
        private final AccountRepository accountRepository;
        private final MovementMapper movementMapper;
        private final CategoryRepository categoryRepository;

        @Override
        public MovementResponseDTO create(CreateMovementRequestDTO dto) {

                // 1️⃣ Obtener username desde JWT
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String username = authentication.getName();

                // 2️⃣ Buscar usuario
                User user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

                // 3️⃣ Obtener persona
                Person person = user.getPerson();

                // 4️⃣ Crear movimiento
                Account source = null;
                Account target = null;
                BigDecimal balanceAfter = null;
                if (dto.getSourceAccountId() != null) {
                        source = accountRepository.findById(dto.getSourceAccountId())
                                        .orElseThrow(() -> new RuntimeException("Source account not found"));
                        validateOwnership(source, person);
                }

                if (dto.getTargetAccountId() != null) {
                        target = accountRepository.findById(dto.getTargetAccountId())
                                        .orElseThrow(() -> new RuntimeException("Target account not found"));
                        validateOwnership(target, person);
                }

                // 🔐 Reglas por tipo
                switch (dto.getType()) {

                        case INCOME -> {
                                if (target == null)
                                        throw new RuntimeException("Income requires target account");

                                balanceAfter = target.getBalance().add(dto.getAmount());
                                target.setBalance(balanceAfter);

                        }

                        case EXPENSE -> {
                                if (source == null)
                                        throw new RuntimeException("Expense requires source account");

                                validateBalance(source, dto.getAmount());

                                balanceAfter = source.getBalance().subtract(dto.getAmount());
                                source.setBalance(balanceAfter);
                        }

                        case TRANSFER -> {
                                if (source == null || target == null)
                                        throw new RuntimeException("Transfer requires both accounts");

                                if (source.getAccountId().equals(target.getAccountId()))
                                        throw new RuntimeException("Cannot transfer to same account");

                                validateBalance(source, dto.getAmount());

                                balanceAfter = source.getBalance().subtract(dto.getAmount());
                                source.setBalance(balanceAfter);

                                target.setBalance(
                                                target.getBalance().add(dto.getAmount()));
                        }
                }

                Movement movement = movementMapper.toEntity(
                                dto, person, source, target, balanceAfter);

                if (dto.getCategoryId() != null) {

                        Category category = categoryRepository.findById(dto.getCategoryId())
                                        .orElseThrow(() -> new RuntimeException("Category not found"));

                        if (!category.getPerson().getPersonId()
                                        .equals(person.getPersonId())) {
                                throw new UnauthorizedException("Category does not belong to user");
                        }

                        movement.setCategory(category);
                }
                movementRepository.save(movement);

                return movementMapper.toResponse(movement);
        }

        // Metodo para validar la propiedad de la cuenta
        private void validateOwnership(Account account, Person person) {
                if (!account.getPerson().getPersonId().equals(person.getPersonId())) {
                        throw new UnauthorizedException("Account does not belong to user");
                }
        }

        // Metodo para validar el balance de la cuenta
        private void validateBalance(Account account, BigDecimal amount) {
                if (account.getBalance().compareTo(amount) < 0) {
                        throw new RuntimeException("Insufficient balance");
                }
        }

        @Override
        public List<MovementResponseDTO> findMyMovements() {

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                String username = authentication.getName();

                User user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

                Long personId = user.getPerson().getPersonId();

                return movementRepository.findByPerson_PersonId(personId)
                                .stream()
                                .map(m -> movementMapper.toResponse(m))
                                .toList();
        }
}
