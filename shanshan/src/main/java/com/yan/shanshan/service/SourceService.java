package com.yan.shanshan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SourceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void update(Integer source){
        if(source > 0){
            jdbcTemplate.update("update t_u_score set `total` = `total` + ?, `add` = `add` + ?", source, source);
        }
        else {
            jdbcTemplate.update("update t_u_score set `total` = `total` + ?, `sub` = `sub` + ?", source, source);
        }
    }
}
