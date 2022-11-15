package com.my.FoodTruckBackend.customer.signup;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    @Size(min = 2, max = 50)
    @NotBlank(message = "Please enter your first name, between 2-50 characters")
    private String firstName;

    @Size(min = 2, max = 50)
    @NotBlank(message = "Please enter your last name, between 2-50 characters")
    private String lastName;

    @Email(message = "Invalid email, please enter valid email address")
    @NotBlank(message = "Please enter a valid email address")
    private String email;

    @Size(min = 8, max = 50)
    @NotBlank(message = "Please choose a unique password, between 8-50 characters")
    private String password;

    @Size(min = 8, max = 50)
    @NotBlank(message = "Please re-enter your unique password, between 8-50 characters")
    private String confirmPassword;
}
