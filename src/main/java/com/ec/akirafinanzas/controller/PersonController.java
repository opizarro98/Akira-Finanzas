package com.ec.akirafinanzas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("personalData")
    public ResponseEntity<BasicPersonalDataResponseDTO> getPersonaData() {
        return ResponseEntity.ok(personService.getPersonalData());
    }

    @PutMapping("UpdatePersonalData")
    public ResponseEntity<Boolean> updatePersonalData(@RequestBody BasicPersonalDataResponseDTO data) {
        return ResponseEntity.ok(personService.updatePersonalData(data));
    }
}
