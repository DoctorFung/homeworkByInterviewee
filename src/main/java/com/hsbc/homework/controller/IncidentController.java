package com.hsbc.homework.controller;

import com.hsbc.homework.model.BaseRespModel;
import com.hsbc.homework.model.IncidentModel;
import com.hsbc.homework.service.IncidentService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@RestController
public class IncidentController {


    @Resource
    private IncidentService incidentService;


    @GetMapping("/getList")
    public List<IncidentModel> getList(){
        return incidentService.getList();
    }

    @GetMapping("/getById")
    public IncidentModel getById(@RequestParam Long id){
        return incidentService.getById(id);
    }

    @PostMapping(value = "/add" , produces = {"application/json"})
    public BaseRespModel add(@RequestBody IncidentModel incidentModel){
        return incidentService.add(incidentModel);
    }

    @PostMapping(value = "/update" , produces = {"application/json"})
    public BaseRespModel update(@RequestBody IncidentModel incidentModel){
        return incidentService.update(incidentModel);
    }

    @PostMapping(value = "/deleteById" , produces = {"application/json"})
    public BaseRespModel deleteById(@RequestParam Long id){
        return incidentService.delete(id);
    }

}
