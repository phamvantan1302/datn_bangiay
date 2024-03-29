package com.example.gatn.Service;


import com.example.gatn.Entity.Lace;

import java.util.List;

public interface LaceService {
    List<Lace> getall();

    Lace getById(Integer id);

    void add(Lace lace);

    void update(Lace lace);
}
