package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Size;
import com.example.gatn.Repositoris.SizeRepository;
import com.example.gatn.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SizeImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getall() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(Integer id) {
        return sizeRepository.getReferenceById(id);
    }

    @Override
    public void add(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void update(Size size) {
        sizeRepository.save(size);
    }
}
