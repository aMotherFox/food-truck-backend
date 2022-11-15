package com.my.FoodTruckBackend.customer.login;

import com.my.FoodTruckBackend.customer.CustomerDto;
import com.my.FoodTruckBackend.customer.SafeUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    private final LoginRepository loginRepository;

    public SafeUser getMatchingUser(LoginRequestBody loginRequestBody) {
        return loginRepository.getMatchingUser(loginRequestBody);
    }
}
