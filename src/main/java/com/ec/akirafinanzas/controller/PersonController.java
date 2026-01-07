package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.person.UpdatePersonDTO;
import com.ec.akirafinanzas.model.dto.person.CreatePersonDTO;
import com.ec.akirafinanzas.service.PersonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/PersonRest")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/GetPersonXId/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @GetMapping("/GetPersonXEmail/{email}")
    public ResponseEntity<?> getPersonByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(personService.getPersonByEmail(email));
    }

    @PostMapping("/Create")
    public ResponseEntity<?> createNewPerson(@Valid @RequestBody CreatePersonDTO person) {
        return ResponseEntity.ok().body(personService.createNewPerson(person));
    }

    @PutMapping("/Update")
    public ResponseEntity<?> updatePerson(@Valid @RequestBody UpdatePersonDTO person) {
        return ResponseEntity.ok().body(personService.updatePerson(person));
    }

    @PutMapping("/Delete/{id}")
    public ResponseEntity<?> deletePerson(@Valid @PathVariable Long id) {
        return ResponseEntity.ok().body(personService.deletePerson(id));
    }
}
