package com.hsbc.homework.common;

import com.hsbc.homework.model.IncidentModel;

import java.util.concurrent.ConcurrentHashMap;

public class DataBaseMemory {

    private static ConcurrentHashMap<Long, IncidentModel> map = new ConcurrentHashMap<>();

    //initialize data
    static {
        map.put(1L , new IncidentModel(1L, "test incident"));
        map.put(2L , new IncidentModel(2L, "online incident"));
        map.put(3L , new IncidentModel(3L, "emergency incident"));
    }

    public static ConcurrentHashMap<Long, IncidentModel> getDataBase(){
        return map;
    }

}
