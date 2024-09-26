package com.hsbc.test;

import com.alibaba.fastjson.JSON;
import com.hsbc.homework.HomeworkApplicaltion;
import com.hsbc.homework.controller.IncidentController;
import com.hsbc.homework.model.IncidentModel;
import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


@SpringBootTest(classes = HomeworkApplicaltion.class)
public class TestCase{

    @Resource
    private IncidentController incidentController;

    @Test
    public void getById(){
        System.out.println(JSON.toJSON(incidentController.getById(1L)));
    }

    @Test
    public void getByList(){
        System.out.println(JSON.toJSON(incidentController.getList()));
    }


    @Test
    public void add(){
        incidentController.add(new IncidentModel(10L,"tmp incident"));
        System.out.println(JSON.toJSON(incidentController.getById(10L)));
    }


    @Test
    public void update(){
        incidentController.update(new IncidentModel(1L,"AB incident"));
        System.out.println(JSON.toJSON(incidentController.getById(1L)));
    }

    @Test
    public void delete(){
        incidentController.deleteById(1L);
        System.out.println(incidentController.getById(1L));
    }

}
