package com.hsbc.homework.service.impl;

import com.hsbc.homework.dao.IncidentDao;
import com.hsbc.homework.model.BaseRespModel;
import com.hsbc.homework.model.IncidentModel;
import com.hsbc.homework.service.IncidentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Resource
    private IncidentDao incidentDao;

    @Override
    public List<IncidentModel> getList() {
        return incidentDao.getList();
    }

    @Override
    public IncidentModel getById(Long id) {
        return incidentDao.getById(id);
    }

    @Override
    public BaseRespModel add(IncidentModel model) {
        if(model == null || model.getId() == null){
            return new BaseRespModel("1001", "id cannot be null");
        }

        try {
            incidentDao.add(model);
        } catch (RuntimeException e){
            return new BaseRespModel("2001", e.getMessage());
        }

        return new BaseRespModel("0000", "success");
    }

    @Override
    public BaseRespModel update(IncidentModel model) {
        if(model == null || model.getId() == null){
            return new BaseRespModel("1001", "id cannot be null");
        }

        try {
            incidentDao.update(model);
        } catch (RuntimeException e){
            return new BaseRespModel("2001", e.getMessage());
        }

        return new BaseRespModel("0000", "success");
    }

    @Override
    public BaseRespModel delete(Long id) {
        if(id == null){
            return new BaseRespModel("1001", "id cannot be null");
        }

        try {
            incidentDao.delete(id);
        } catch (RuntimeException e){
            return new BaseRespModel("2001", e.getMessage());
        }

        return new BaseRespModel("0000", "success");
    }


}
