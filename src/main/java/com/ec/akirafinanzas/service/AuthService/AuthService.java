package com.ec.akirafinanzas.service.AuthService;

import com.ec.akirafinanzas.model.dto.authapp.AuthRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.AuthResponseDTO;
import com.ec.akirafinanzas.model.dto.authapp.RegisterRequestDTO;
import com.ec.akirafinanzas.model.dto.authapp.UpdatePassRequestDTO;

public interface AuthService {

    public boolean register(RegisterRequestDTO authRequestDTO);

    public AuthResponseDTO login(AuthRequestDTO authRequestDTO);

    public boolean updatePassword(UpdatePassRequestDTO authRequestDTO);
}
