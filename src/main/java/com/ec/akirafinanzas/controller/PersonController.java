package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.akirafinanzas.model.dto.person.BasicPersonalDataResponseDTO;
import com.ec.akirafinanzas.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("personalData/{personid}")
    public ResponseEntity<BasicPersonalDataResponseDTO> getPersonaData(@PathVariable Long personid) {
        return ResponseEntity.ok(personService.getPersonalData(personid));
    }
}
