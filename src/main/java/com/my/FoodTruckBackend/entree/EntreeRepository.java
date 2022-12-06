package com.my.FoodTruckBackend.entree;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Slf4j
public class EntreeRepository {
    private final JdbcTemplate jdbcTemplate;

    public Entree createNewEntree(EntreeRequestBody entreeRequestBody) {
        String sql = "INSERT INTO entree(name,description,price) VALUES(?,?,?) RETURNING *";
try {
    Entree newEntree = jdbcTemplate.queryForObject(
        sql,
        new BeanPropertyRowMapper<>(Entree.class),
        entreeRequestBody.getName().trim(),
        entreeRequestBody.getDescription(),
        entreeRequestBody.getPrice()
    );
    return newEntree;
} catch (ResponseStatusException responseStatusException) {
    String errorMessage = "Entree:" + entreeRequestBody.getName() + "could not be added";
    log.error(errorMessage);
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);

}

    }
    public List<Entree> gettingAllEntree() {
        String sql = "SELECT * FROM entree";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Entree.class));

    }


}
