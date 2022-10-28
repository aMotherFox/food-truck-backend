package com.my.FoodTruckBackend.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    @NotBlank(message = "Please enter your first name")
    private String firstName;

    @NotBlank(message = "Please enter your last name")
    private String lastName;

    @Email(message = "Invalid email, please enter valid email address")
    @NotBlank(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Please choose a unique password")
    private String password;

    @NotBlank(message = "Passwords much match")
    private String confirmPassword;
}
