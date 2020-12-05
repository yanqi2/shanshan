package com.yan.shanshan.controller;

import com.yan.shanshan.model.Operation;
import com.yan.shanshan.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController()
public class OperationController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/operation/list")
    public List<Operation> list(int page, int size) {
        return jdbcTemplate.query("select * from t_operation where `type` = 1 limit "+(page - 1) * size+"" + size, new RowMapper<Operation>() {
            @Override
            public Operation mapRow(ResultSet resultSet, int i) throws SQLException {
                Operation operation = new Operation();
                operation.setId(resultSet.getInt("id"));
                operation.setType(resultSet.getShort("type"));
                operation.setMsg(resultSet.getString("msg"));
                operation.setDt(resultSet.getDate("dt"));
                return operation;
            }
        });
    }
}
