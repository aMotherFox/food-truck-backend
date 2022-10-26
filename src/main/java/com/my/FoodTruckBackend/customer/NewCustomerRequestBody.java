package com.my.FoodTruckBackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @Email(message = "Invalid email, please enter vaild email address")
    private String email;

    @NotBlank(message = "Last name must not be blank")
    private String password;

    @NotBlank(message = "Passwords much match")
    private String confirmPassword;
}
