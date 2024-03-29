package com.example.gatn.Service;

import com.example.gatn.Entity.Sole;

import java.util.List;

public interface SoleService {
    List<Sole> getall();

    Sole getById(Integer id);

    void add(Sole sole);

    void update(Sole sole);
}
