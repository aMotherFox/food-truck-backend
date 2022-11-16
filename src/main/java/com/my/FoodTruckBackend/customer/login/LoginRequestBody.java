package com.my.FoodTruckBackend.customer.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequestBody {
    private String email;
    private String password;
}

