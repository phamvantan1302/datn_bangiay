package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Brand;
import com.example.gatn.Repositoris.BrandRepository;
import com.example.gatn.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BrandImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getall() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.getReferenceById(id);
    }

    @Override
    public void add(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void update(Brand brand) {
        brandRepository.save(brand);
    }
}
