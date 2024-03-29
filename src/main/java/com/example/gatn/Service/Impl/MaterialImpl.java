package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Material;
import com.example.gatn.Repositoris.MaterialRepository;
import com.example.gatn.Service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MaterialImpl implements MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getall() {
        return materialRepository.findAll();
    }

    @Override
    public Material getById(Integer id) {
        return materialRepository.getReferenceById(id);
    }

    @Override
    public void add(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void update(Material material) {
        materialRepository.save(material);
    }
}
