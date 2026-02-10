package com.ec.akirafinanzas.service.impl;

import org.springframework.stereotype.Service;

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
    public BasicPersonalDataResponseDTO getPersonalData(Long data) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++ :" + data);
        Person findPerson = personRepository.findByPersonId(data);

        return personMapper.toEntityGet(findPerson);
    }

}
