package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Color;
import com.example.gatn.Repositoris.ColorRepository;
import com.example.gatn.Service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ColorImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getall() {
        return colorRepository.findAll();
    }

    @Override
    public Color getById(Integer id) {
        return colorRepository.getReferenceById(id);
    }

    @Override
    public void add(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void update(Color color) {
        colorRepository.save(color);
    }
}
