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

/*
* you will need to create a safe user model
* */

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
*
* create a thing that gets the customer by the email and password, right now you are
* getting them only by customers. this should be in the customer repository. You might
* need to make the customer repository sharable between the two so move it up a directory.
* */