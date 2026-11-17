package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@RestController
public class DataController {

    private final JdbcTemplate jdbcTemplate;

    public DataController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/data")
    public Map<String, Object> getData() {

        return jdbcTemplate.queryForMap(
            "SELECT DATABASE() AS database_name, VERSION() AS mysql_version"
        );
    }
}
