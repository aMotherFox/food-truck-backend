package com.my.FoodTruckBackend.entree;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
@Slf4j
public class EntreeRepository {
    private final JdbcTemplate jdbcTemplate;

    public EntreeDto createNewEntree(NewEntreeRequestBody newEntreeRequestBody) {
        String sql = "";

    }


}
