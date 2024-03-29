package com.example.gatn.Service;

import com.example.gatn.Entity.Color;

import java.util.List;

public interface ColorService {

    List<Color> getall();

    Color getById(Integer id);

    void add(Color color);

    void update(Color color);
}
