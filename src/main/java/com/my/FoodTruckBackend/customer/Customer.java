package com.my.FoodTruckBackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private String confirmPassword; do not insert into DB, not relevant after signing up
}