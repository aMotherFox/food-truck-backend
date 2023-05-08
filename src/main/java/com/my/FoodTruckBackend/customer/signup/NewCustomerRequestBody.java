package com.my.FoodTruckBackend.customer.signup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    @NotBlank(message = "Please enter your first name, between 2-50 characters")
    private String firstName;

    @NotBlank(message = "Please enter your last name, between 2-50 characters")
    private String lastName;

    @Email(message = "Invalid email, please enter valid email address")
    @NotBlank(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Please choose a unique password, between 8-50 characters")
    private String password;

    @NotBlank(message = "Please re-enter your unique password, between 8-50 characters")
    private String confirmPassword;
}
