package com.my.FoodTruckBackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    private String firstName;
    private String lastName;

    @Email
    private String email;
    private String password;
    private String confirmPassword;
}
