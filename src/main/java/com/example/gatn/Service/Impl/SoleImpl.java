package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Sole;
import com.example.gatn.Repositoris.SoleRepository;
import com.example.gatn.Service.SoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SoleImpl implements SoleService {
    @Autowired
    private SoleRepository soleRepository;
    @Override
    public List<Sole> getall() {
        return soleRepository.findAll();
    }

    @Override
    public Sole getById(Integer id) {
        return soleRepository.getReferenceById(id);
    }

    @Override
    public void add(Sole sole) {
        soleRepository.save(sole);
    }

    @Override
    public void update(Sole sole) {
        soleRepository.save(sole);
    }
}
