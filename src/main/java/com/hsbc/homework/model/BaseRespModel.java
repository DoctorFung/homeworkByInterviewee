package com.hsbc.homework.model;

import java.io.Serializable;

public class BaseRespModel implements Serializable {

    private String code;

    private String desc;

    public BaseRespModel() {
    }

    public BaseRespModel(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
