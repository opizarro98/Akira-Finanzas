package com.ec.akirafinanzas.service.AuthService;

import com.ec.akirafinanzas.model.dto.authapp.AuthRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.AuthResponseDTO;

public interface AuthService {

    public boolean register(AuthRequestDTO authRequestDTO);

    public AuthResponseDTO login(AuthRequestDTO authRequestDTO);
}
