package com.example.gatn.Service;

import com.example.gatn.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getall();

    Category getById(Integer id);

    void add(Category category);

    void update(Category category);
}
