package com.my.FoodTruckBackend.customer.login;

import com.my.FoodTruckBackend.customer.CustomerDto;
import com.my.FoodTruckBackend.customer.SafeUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    // ------------match a customer to the email and password
    @PostMapping("/login")
    public SafeUser loggingInUser(@RequestBody LoginRequestBody loginRequestBody) {
        return loginService.loggingInUser(loginRequestBody);
    }
}
