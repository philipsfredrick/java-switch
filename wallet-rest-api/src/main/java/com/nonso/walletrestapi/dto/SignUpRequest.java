package com.nonso.walletrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "Missing required field. Name cannot be blank")
    private String name;

    @NotBlank(message = "Missing required field. Phone number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Missing required field. Address cannot be blank")
    private String address;
}
