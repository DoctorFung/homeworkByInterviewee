package com.hsbc.homework.service;

import com.hsbc.homework.model.BaseRespModel;
import com.hsbc.homework.model.IncidentModel;
import java.util.List;

public interface IncidentService {


    List<IncidentModel> getList();


    BaseRespModel add(IncidentModel model);


    BaseRespModel update(IncidentModel model);


    BaseRespModel delete(Long id);

    IncidentModel getById(Long id);
}
