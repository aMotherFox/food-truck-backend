package com.my.FoodTruckBackend.customer.signup;

import com.my.FoodTruckBackend.customer.CustomerDto;
import com.my.FoodTruckBackend.customer.signup.NewCustomerRequestBody;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<CustomerDto> getListOfCustomers() {
        String sql = "SELECT * FROM customer";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CustomerDto.class));
    }

    public CustomerDto createNewCustomers(NewCustomerRequestBody newCustomerRequestBody) {
        String sql = "INSERT INTO customer (first_name, last_name, email, password) VALUES (?, ?, ?, ?) RETURNING *";

        try {
            return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(CustomerDto.class),
                newCustomerRequestBody.getFirstName().trim(),
                newCustomerRequestBody.getLastName().trim(),
                newCustomerRequestBody.getEmail().trim(),
                newCustomerRequestBody.getPassword().trim()
            );
        } catch (DuplicateKeyException duplicateKeyException) {
            String errorMessage = "Email is already registered: " + newCustomerRequestBody.getEmail();
            log.error(errorMessage);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
}
