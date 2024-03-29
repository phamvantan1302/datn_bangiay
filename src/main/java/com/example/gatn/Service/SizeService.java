package com.example.gatn.Service;

import com.example.gatn.Entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> getall();

    Size getById(Integer id);

    void add(Size size);

    void update(Size size);
}
