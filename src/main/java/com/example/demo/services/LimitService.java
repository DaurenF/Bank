package com.example.demo.services;

import com.example.demo.models.Limit;
import com.example.demo.repositories.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)

public class LimitService {
    private final LimitRepository limitRepository;

    @Autowired
    public LimitService(LimitRepository limitRepository) {
        this.limitRepository = limitRepository;
    }

    public Limit getLimit(int id) {
        return limitRepository.findById(id).orElse(null);
    }


    @Transactional
    public void save(Limit limit){

        if(limit.getCategory().isEmpty()){
            limit.setValue(0);
            limit.setRemaining_usd(0);
        }
        limitRepository.save(limit);
    }

    @SchemaMapping
    public List<Limit> getAllLimits(){
        return limitRepository.findAll();
    }



}
