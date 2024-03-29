package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.ProductDetail;
import com.example.gatn.Repositoris.ProductDetailReponsitoty;
import com.example.gatn.Service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailImpl implements ProductDetailService {
    @Autowired
    private ProductDetailReponsitoty productDetailReponsitoty;

    @Override
    public ProductDetail getById(Integer id) {
        return productDetailReponsitoty.getReferenceById(id);
    }

    @Override
    public void add(ProductDetail productDetail) {
        productDetailReponsitoty.save(productDetail);
    }

    @Override
    public void update(ProductDetail productDetail) {
        productDetailReponsitoty.save(productDetail);
    }

    @Override
    public Page<ProductDetail> search(String key, Pageable pageable) {
        return productDetailReponsitoty.search(key, pageable);
    }

    @Override
    public Page<ProductDetail> getall(Integer key, Pageable pageable) {
        return productDetailReponsitoty.getByStatus(key, pageable);
    }
}
