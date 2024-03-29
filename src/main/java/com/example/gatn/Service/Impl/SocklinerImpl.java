package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Sockliner;
import com.example.gatn.Repositoris.SocklinerRepository;
import com.example.gatn.Service.SocklinerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SocklinerImpl implements SocklinerService {
    @Autowired
    private SocklinerRepository socklinerRepository;
    @Override
    public List<Sockliner> getall() {
        return socklinerRepository.findAll();
    }

    @Override
    public Sockliner getById(Integer id) {
        return socklinerRepository.getReferenceById(id);
    }

    @Override
    public void add(Sockliner sockliner) {
        socklinerRepository.save(sockliner);
    }

    @Override
    public void update(Sockliner sockliner) {
        socklinerRepository.save(sockliner);
    }
}
