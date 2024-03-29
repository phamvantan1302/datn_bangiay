package com.example.gatn.Service;

import com.example.gatn.Entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductDetailService {

    ProductDetail getById(Integer id);

    void add(ProductDetail productDetail);

    void update(ProductDetail productDetail);

    Page<ProductDetail> search(String key, Pageable pageable);

    Page<ProductDetail> getall(Integer key, Pageable pageable);
}
