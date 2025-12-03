package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.person.createPersonDTO;

public interface PersonService {

    createPersonDTO createNewPerson(createPersonDTO person);
}
