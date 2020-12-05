package com.yan.shanshan.controller;

import com.yan.shanshan.model.UserScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController()
public class UserScoreController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/user/score")
    public UserScore getUserScore(){
        List<UserScore> query = jdbcTemplate.query("select * from t_u_score;", new RowMapper<UserScore>() {
            @Override
            public UserScore mapRow(ResultSet resultSet, int i) throws SQLException {
                UserScore u = new UserScore();
                u.setId(resultSet.getInt("id"));
                u.setTotal(resultSet.getInt("total"));
                u.setAdd(resultSet.getInt("add"));
                u.setSub(resultSet.getInt("sub"));
                return u;
            }
        });
        return query.get(0);
    }
}
