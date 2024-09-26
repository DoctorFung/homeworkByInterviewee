package com.hsbc.homework.model;



public class IncidentModel {

    private Long id;

    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public IncidentModel(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
