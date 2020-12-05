package com.yan.shanshan.model;

import java.util.Date;

public class Operation {
    private Integer id;
    private Short type;  // 1 加减分 2 新增/删除/修改 Option
    private String msg;
    private Date dt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
}
