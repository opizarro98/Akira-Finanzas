package com.ec.akirafinanzas.model.dto.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPersonCompleteDTO {
    @NotNull(message = "id is required")
    private Long personId;

    @NotBlank(message = "firstName is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "lastName is required")
    private String lastName;

    private String secondLastName;

    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

    private String phone;
}
