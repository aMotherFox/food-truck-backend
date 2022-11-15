package com.my.FoodTruckBackend.customer.login;

import com.my.FoodTruckBackend.customer.Customer;
import com.my.FoodTruckBackend.customer.CustomerDto;
import com.my.FoodTruckBackend.customer.SafeUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class LoginRepository {

    private final JdbcTemplate jdbcTemplate;

    public SafeUser getMatchingUser(LoginRequestBody loginRequestBody) {
        String sql = "SELECT FROM customer WHERE email = ? AND password = ?";

        System.out.println("email" + loginRequestBody.getEmail());
        System.out.println("password" + loginRequestBody.getPassword());
        try {
            SafeUser matchedCustomer = jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(SafeUser.class),
                loginRequestBody.getEmail(),
                loginRequestBody.getPassword()
            );
            return matchedCustomer;
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            log.error("No customer found with this email or password.");
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No customer found with this email or password"
            );
        }
    }
}
