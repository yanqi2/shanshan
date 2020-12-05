package com.yan.shanshan.service;

import com.yan.shanshan.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void add(String title, Integer score){
        jdbcTemplate.update("insert into t_option (`title`,`score`) values (?,?)", title, score);
    }

    @Transactional
    public void update(Integer id, String title, Integer score){
        jdbcTemplate.update("update t_option set title = ?,score = ? where id = ?", title, score, id);
    }

    @Transactional
    public void delete(Integer id){
        jdbcTemplate.update("update t_option set state = 0 where id = ?", id);
    }

    @Transactional
    public void touch(Integer id){
        jdbcTemplate.update("update t_option set `count` = `count` + 1 where id = ?", id);
    }

    public Option get(Integer id){
        List<Option> query = jdbcTemplate.query("select * from t_option where id = " + id, (resultSet, i) -> {
            Option option = new Option();
            option.setId(resultSet.getInt("id"));
            option.setTitle(resultSet.getString("title"));
            option.setScore(resultSet.getInt("score"));
            return option;
        });
        return query.get(0);
    }
}
