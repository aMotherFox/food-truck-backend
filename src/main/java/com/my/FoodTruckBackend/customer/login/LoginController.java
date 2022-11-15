package com.my.FoodTruckBackend.customer.login;

import com.my.FoodTruckBackend.customer.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    // ------------match a customer to the email and password
    @GetMapping("/login/")
    public CustomerDto loginRequestBody() {
        return loginService.getMatchingUser();
    }
}
