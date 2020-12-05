package com.yan.shanshan.controller;

import com.yan.shanshan.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController()
public class OptionController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/option/list")
    public List<Option> list() {
        List<Option> query = jdbcTemplate.query("select * from t_option where state = 1 order by id desc",
                new RowMapper<Option>() {
                    @Override
                    public Option mapRow(ResultSet resultSet, int i) throws SQLException {
                        Option option = new Option();
                        option.setId(resultSet.getInt("id"));
                        option.setTitle(resultSet.getString("title"));
                        option.setScore(resultSet.getInt("score"));
                        return option;
                    }
                });
        return query;
    }
}
