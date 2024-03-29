package com.example.gatn.Service;

import com.example.gatn.Entity.Sockliner;

import java.util.List;

public interface SocklinerService {
    List<Sockliner> getall();

    Sockliner getById(Integer id);

    void add(Sockliner sockliner);

    void update(Sockliner sockliner);
}
