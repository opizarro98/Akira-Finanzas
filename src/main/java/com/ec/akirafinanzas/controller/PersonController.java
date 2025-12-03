package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.person.createPersonDTO;
import com.ec.akirafinanzas.service.PersonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/PersonRest")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/Create")
    public ResponseEntity<?> createNewPerson(@Valid @RequestBody createPersonDTO person) {
        return ResponseEntity.ok().body(personService.createNewPerson(person));
    }
}
