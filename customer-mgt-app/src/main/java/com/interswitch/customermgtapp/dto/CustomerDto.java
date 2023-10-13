package com.interswitch.customermgtapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    @NotBlank(message = "full name cannot be blank")
    private String fullName;
    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;
}
