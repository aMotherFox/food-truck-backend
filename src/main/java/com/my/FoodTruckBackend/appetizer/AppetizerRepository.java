package com.my.FoodTruckBackend.appetizer;

import java.util.ArrayList;
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
public class AppetizerRepository {
    private final JdbcTemplate jdbcTemplate;

    public Appetizer createNewAppetizers(NewAppetizerRequestBody newAppetizerRequestBody) {
        String sql = "INSERT INTO appetizer(name,description,price) VALUES(?, ?, ?) RETURNING *";

        try {
            return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Appetizer.class),
                newAppetizerRequestBody.getName().trim(),
                newAppetizerRequestBody.getDescription().trim(),
                newAppetizerRequestBody.getPrice()
            );
        } catch (DuplicateKeyException duplicateKeyException) {
            String errorMessage = "Appetizer already exists: " + newAppetizerRequestBody.getName();
            log.error(errorMessage);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }

    public ArrayList<Appetizer> getListOfAppetizers() {
        String sql = "SELECT * FROM appetizer";
        return (ArrayList<Appetizer>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Appetizer.class));
    }
}
