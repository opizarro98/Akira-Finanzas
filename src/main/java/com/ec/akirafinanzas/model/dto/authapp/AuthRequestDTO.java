package com.ec.akirafinanzas.model.dto.authapp;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
