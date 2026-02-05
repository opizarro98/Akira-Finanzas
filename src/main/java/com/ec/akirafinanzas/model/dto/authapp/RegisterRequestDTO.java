package com.ec.akirafinanzas.model.dto.authapp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
