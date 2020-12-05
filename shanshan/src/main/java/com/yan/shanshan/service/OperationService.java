package com.yan.shanshan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void add(Integer type, String msg){
        System.out.println(msg);
        jdbcTemplate.update("insert into t_operation (`type`,`msg`, `dt`) values (?,?,now())", type, msg);
    }
}
