package com.my.FoodTruckBackend.customer.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Login {
    private String email;
    private String password;

}

//login endpoint
/*
* front end sends email and password to the back end
* BE receives this data
* checks the db for a matching email
* checks the db for matching password
* if both of these are found,
* return a safe user with id, email, and password
* give a 200 success code
*
* */