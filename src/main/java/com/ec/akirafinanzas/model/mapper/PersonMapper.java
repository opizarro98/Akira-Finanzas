package com.ec.akirafinanzas.model.mapper;

import org.springframework.stereotype.Component;

import com.ec.akirafinanzas.model.dto.person.BasicPersonalDataResponseDTO;
import com.ec.akirafinanzas.model.entity.Person;

@Component
public class PersonMapper {

    public BasicPersonalDataResponseDTO toEntityGet(Person person) {
        return BasicPersonalDataResponseDTO.builder()
                .firstName(person.getFirstName())
                .middleName(person.getMiddleName())
                .lastName(person.getLastName())
                .secondLastName(person.getSecondLastName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .build();
    }
}
