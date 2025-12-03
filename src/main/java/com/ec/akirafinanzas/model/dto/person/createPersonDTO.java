package com.ec.akirafinanzas.model.dto.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createPersonDTO {

    @NotBlank(message = "firstName is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "lastName is required")
    private String lastName;

    private String secondLastName;

    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

}
