package com.example.gatn.Service;

import com.example.gatn.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getall();

    Product getById(Integer id);

    void add(Product product);

    void update(Product product);
}
