package com.my.FoodTruckBackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewCustomerRequestBody {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}
