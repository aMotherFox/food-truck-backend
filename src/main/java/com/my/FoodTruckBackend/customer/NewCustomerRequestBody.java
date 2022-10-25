package com.my.FoodTruckBackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    @NotBlank @NotNull @NotEmpty
    private String firstName;

    @NotBlank @NotNull @NotEmpty
    private String lastName;

    @Email
    private String email;

    @NotBlank @NotNull @NotEmpty
    private String password;

    @NotBlank @NotNull @NotEmpty
    private String confirmPassword;
}
