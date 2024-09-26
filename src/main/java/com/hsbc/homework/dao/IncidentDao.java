package com.hsbc.homework.dao;

import com.hsbc.homework.common.DataBaseMemory;
import com.hsbc.homework.model.IncidentModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hsbc.homework.constant.CacheConstant.CACHE_KEY_NAME;

@Service
public class IncidentDao {


    public List<IncidentModel> getList(){
        return DataBaseMemory.getDataBase().values().stream().toList();
    }

    @Cacheable(value = CACHE_KEY_NAME, key = "'by_id_' + #id")
    public IncidentModel getById(Long id){
        return DataBaseMemory.getDataBase().get(id);
    }

    @CacheEvict(value = CACHE_KEY_NAME, key = "'by_id_' + #model.id")
    public int add(IncidentModel model){
        if(DataBaseMemory.getDataBase().containsKey(model.getId())){
            throw new RuntimeException("the model whose id equals " + model.getId() + " to be added already exists!");
        }

        DataBaseMemory.getDataBase().put(model.getId(), model);

        return 1;
    }

    @CacheEvict(value = CACHE_KEY_NAME, key = "'by_id_' + #model.id")
    public int update(IncidentModel model){
        if(!DataBaseMemory.getDataBase().containsKey(model.getId())){
            throw new RuntimeException("the model whose id equals " + model.getId() + " to be updated doesn't exist!");
        }

        DataBaseMemory.getDataBase().put(model.getId(), model);

        return 1;
    }

    @CacheEvict(value = CACHE_KEY_NAME, key = "'by_id_' + #id")
    public int delete(Long id){
        if(!DataBaseMemory.getDataBase().containsKey(id)){
            throw new RuntimeException("the model whose id equals " + id + " to be deleted doesn't exist!");
        }

        DataBaseMemory.getDataBase().remove(id);

        return 1;
    }
}
