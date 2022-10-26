package com.my.FoodTruckBackend.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Customer> getListOfCustomers() {

        String sql = "SELECT * FROM customer";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer createNewCustomers(NewCustomerRequestBody newCustomerRequestBody) {
        String sql = "INSERT INTO customer (first_name, last_name, email, password) VALUES (?, ?, ?, ?) RETURNING *";

        return jdbcTemplate.queryForObject(
          sql,
          new BeanPropertyRowMapper<>(Customer.class),
          newCustomerRequestBody.getFirstName(),
          newCustomerRequestBody.getLastName(),
          newCustomerRequestBody.getEmail(),
          newCustomerRequestBody.getPassword()
        );

//        try {
//            return jdbcTemplate.queryForObject(
//                sql,
//                new BeanPropertyRowMapper<>(Customer.class),
//                newCustomerRequestBody.getFirstName(),
//                newCustomerRequestBody.getLastName(),
//                newCustomerRequestBody.getEmail(),
//                newCustomerRequestBody.getPassword()
//            );
//        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
//            log.error("Unable to create customer");
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid customer");
//        }

    }
}
