package com.ec.akirafinanzas.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.error.ResourceNotFoundException;
import com.ec.akirafinanzas.model.dto.person.BasicPersonalDataResponseDTO;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.mapper.PersonMapper;
import com.ec.akirafinanzas.repository.PersonRepository;
import com.ec.akirafinanzas.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public BasicPersonalDataResponseDTO getPersonalData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Long personId = (Long) authentication.getDetails();

        Person findPerson = personRepository.findByPersonId(personId);

        return personMapper.toEntityGet(findPerson);
    }

    @Override
    public Boolean updatePersonalData(BasicPersonalDataResponseDTO data) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Long personId = (Long) authentication.getDetails();
        Person updatePerson = personRepository.findByPersonId(personId);
        if (updatePerson == null) {
            throw new ResourceNotFoundException("Person not found");
        }
        updatePerson.setFirstName(data.getFirstName());
        updatePerson.setMiddleName(data.getMiddleName());
        updatePerson.setLastName(data.getLastName());
        updatePerson.setSecondLastName(data.getSecondLastName());
        updatePerson.setEmail(data.getEmail());
        updatePerson.setPhone(data.getPhone());

        personRepository.save(updatePerson);

        return true;
    }

}
