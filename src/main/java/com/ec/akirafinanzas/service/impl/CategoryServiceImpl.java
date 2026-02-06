package com.ec.akirafinanzas.service.impl;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.error.UnauthorizedException;
import com.ec.akirafinanzas.model.dto.category.CategoryResponseDTO;
import com.ec.akirafinanzas.model.dto.category.CreateCategoryRequestDTO;
import com.ec.akirafinanzas.model.entity.Category;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.entity.User;
import com.ec.akirafinanzas.model.mapper.CategoryMapper;
import com.ec.akirafinanzas.repository.CategoryRepository;
import com.ec.akirafinanzas.repository.UserRepository;
import com.ec.akirafinanzas.service.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponseDTO create(CreateCategoryRequestDTO dto) {

        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("User not found"));

        Person person = user.getPerson();

        boolean exists = categoryRepository.existsByNameAndPerson(dto.getName(), person);

        if (exists) {
            throw new RuntimeException("Category already exists");
        }

        Category category = categoryMapper.toEntity(dto, person);

        categoryRepository.save(category);

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponseDTO> list() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("User not found"));

        Person person = user.getPerson();

        List<Category> categories = categoryRepository.findByPerson(person);

        return categories.stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
