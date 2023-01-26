package com.my.FoodTruckBackend.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public Order createOrder(NewOrderRequestBody newOrderRequestBody) {
        String newOrderSql = "INSERT INTO \"order\" (customer_id) VALUES (?) RETURNING *";

        Order newOrder = jdbcTemplate.queryForObject(
            newOrderSql,
            new BeanPropertyRowMapper<>(Order.class),
            newOrderRequestBody.getCustomerId()
        );
        return newOrder;
    }

}
