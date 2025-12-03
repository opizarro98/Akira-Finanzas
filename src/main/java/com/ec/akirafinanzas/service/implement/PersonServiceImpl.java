package com.ec.akirafinanzas.service.implement;

import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.dto.person.createPersonDTO;
import com.ec.akirafinanzas.model.entity.Person;
import com.ec.akirafinanzas.model.mapper.PersonMapper;
import com.ec.akirafinanzas.repository.PersonRepository;
import com.ec.akirafinanzas.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Override
    public createPersonDTO createNewPerson(createPersonDTO person) {
        Person newPerson = personMapper.toEntityCreate(person);
        return personMapper.toDTOCreate(personRepository.save(newPerson));
    }

}
