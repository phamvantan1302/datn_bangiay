package com.example.gatn.Service;

import com.example.gatn.Entity.Brand;
import com.example.gatn.Entity.ProductDetail;

import java.util.List;

public interface BrandService {
    List<Brand> getall();

    Brand getById(Integer id);

    void add(Brand brand);

    void update(Brand brand);
}
