package com.example.gatn.Service;

import com.example.gatn.Entity.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getall();

    Material getById(Integer id);

    void add(Material material);

    void update(Material material);
}
