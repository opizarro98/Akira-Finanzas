package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.person.UpdatePersonDTO;
import com.ec.akirafinanzas.model.dto.person.CreatePersonDTO;
import com.ec.akirafinanzas.model.dto.person.GetPersonCompleteDTO;

public interface PersonService {

    CreatePersonDTO createNewPerson(CreatePersonDTO person);

    UpdatePersonDTO updatePerson(UpdatePersonDTO person);

    Boolean deletePerson(Long id);

    GetPersonCompleteDTO getPersonById(Long id);
}
