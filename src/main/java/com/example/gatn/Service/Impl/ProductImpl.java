package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.Product;
import com.example.gatn.Repositoris.ProductRepository;
import com.example.gatn.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getall() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }
}
