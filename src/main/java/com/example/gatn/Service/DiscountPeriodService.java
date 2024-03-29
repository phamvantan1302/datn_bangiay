package com.example.gatn.Service;



import com.example.gatn.Entity.DiscountPeriod;

import java.util.List;

public interface DiscountPeriodService {
    List<DiscountPeriod> getall();

    DiscountPeriod getonebyid(Integer id);

    void delete(Integer id);

    void add(DiscountPeriod discountPeriod);

    void update(DiscountPeriod discountPeriod);
}
