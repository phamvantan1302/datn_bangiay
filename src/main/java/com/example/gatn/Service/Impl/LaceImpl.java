package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Lace;
import com.example.gatn.Repositoris.LaceRepository;
import com.example.gatn.Service.LaceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LaceImpl implements LaceService {
    @Autowired
    private LaceRepository laceRepository;

    @Override
    public List<Lace> getall() {
        return laceRepository.findAll();
    }

    @Override
    public Lace getById(Integer id) {
        return laceRepository.getReferenceById(id);
    }

    @Override
    public void add(Lace lace) {
        laceRepository.save(lace);
    }

    @Override
    public void update(Lace lace) {
        laceRepository.save(lace);
    }
}
