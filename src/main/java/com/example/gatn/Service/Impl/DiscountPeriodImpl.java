package com.example.gatn.Service.Impl;

import com.example.gatn.Entity.DiscountPeriod;
import com.example.gatn.Repositoris.DiscountPeriodReponsitory;
import com.example.gatn.Service.DiscountPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountPeriodImpl implements DiscountPeriodService {
    @Autowired
    private DiscountPeriodReponsitory discountPeriodReponsitory;

    @Override
    public List<DiscountPeriod> getall() {
        return discountPeriodReponsitory.findAll();
    }

    @Override
    public DiscountPeriod getonebyid(Integer id) {
        return discountPeriodReponsitory.getReferenceById(id);
    }

    @Override
    public void delete(Integer id) {
        discountPeriodReponsitory.deleteById(id);
    }

    @Override
    public void add(DiscountPeriod discountPeriod) {
        discountPeriodReponsitory.save(discountPeriod);
    }

    @Override
    public void update(DiscountPeriod discountPeriod) {
        discountPeriodReponsitory.save(discountPeriod);
    }
}
