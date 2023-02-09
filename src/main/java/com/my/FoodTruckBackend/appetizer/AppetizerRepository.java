package com.my.FoodTruckBackend.appetizer;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "INSERT INTO appetizer (name, price) VALUES (?, ?) RETURNING *";

        try {
            return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Appetizer.class),
                newAppetizerRequestBody.getName().trim(),
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

    public Appetizer getAppetizerById(Integer id) {
        String sql = "SELECT * FROM appetizer WHERE id = ?";
        try {
            Appetizer appetizerById = jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Appetizer.class),
                id
            );
            return appetizerById;
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            log.error("no appetizer found with this id: "+ id);
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No appetizer found with this id: " + id
            );

        }
    }
}
