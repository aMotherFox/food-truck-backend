package com.my.FoodTruckBackend.entree;

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
public class EntreeRepository {
    private final JdbcTemplate jdbcTemplate;

    public Entree createNewEntree(EntreeRequestBody entreeRequestBody) {
        String sql = "INSERT INTO entree(name,description,price) VALUES(?,?,?) RETURNING *";
        try {
            return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Entree.class),
                entreeRequestBody.getName().trim(),
                entreeRequestBody.getDescription().trim(),
                entreeRequestBody.getPrice()
            );
        } catch (DuplicateKeyException duplicateKeyException) {
            String errorMessage = "Entree:" + entreeRequestBody.getName() + "already exists";
            log.error(errorMessage);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }

    public List<Entree> gettingAllEntree() {
        String sql = "SELECT * FROM entree";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Entree.class));
    }
}
