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
public class UpdatePassRequestDTO {
    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;
}
