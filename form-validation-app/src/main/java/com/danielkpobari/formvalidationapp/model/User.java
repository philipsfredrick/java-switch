package com.danielkpobari.formvalidationapp.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotEmpty(message = "Required field. Username must not be empty")
    @Size(message = "must be greater than 4 characters", min = 4)
    private String username;

    @NotEmpty(message = "Required field. Email cannot be empty")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotEmpty(message = "Required field. Password cannot be empty")
    @Pattern(message = "Enter a valid password", regexp = "")
    private String password;

//    @Past
    @NotEmpty(message = "Date of Birth cannot be blank")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String dateOfBirth;

    @Min(16)
    private Integer age;
}
