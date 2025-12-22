package com.ec.akirafinanzas.service.implement;

import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.dto.person.UpdatePersonDTO;
import com.ec.akirafinanzas.model.dto.person.CreatePersonDTO;
import com.ec.akirafinanzas.model.dto.person.GetPersonCompleteDTO;
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
    public GetPersonCompleteDTO getPersonById(Long id) {
        Person person = personRepository.getReferenceById(id);
        return personMapper.toDTOComplete(person);
    }

    @Override
    public CreatePersonDTO createNewPerson(CreatePersonDTO person) {
        Person newPerson = personMapper.toEntityCreate(person);
        return personMapper.toDTOCreate(personRepository.save(newPerson));
    }

    @Override
    public UpdatePersonDTO updatePerson(UpdatePersonDTO person) {
        Person existingPerson = personRepository.getReferenceById(person.getPersonId());
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setMiddleName(person.getMiddleName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setSecondLastName(person.getSecondLastName());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setPhone(person.getPhone());
        return personMapper.toDTOUpdate(personRepository.save(existingPerson));
    }

    @Override
    public Boolean deletePerson(Long id) {
        Person person = personRepository.getReferenceById(id);
        person.setActive(false);
        personRepository.save(person);
        return true;
    }

}
