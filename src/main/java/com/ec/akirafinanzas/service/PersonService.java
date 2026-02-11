package com.ec.akirafinanzas.service;

import com.ec.akirafinanzas.model.dto.person.BasicPersonalDataResponseDTO;

public interface PersonService {

    public BasicPersonalDataResponseDTO getPersonalData();

    public Boolean updatePersonalData(BasicPersonalDataResponseDTO data);
}
