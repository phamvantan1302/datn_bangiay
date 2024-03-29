package com.example.gatn.Repositoris;

import com.example.gatn.Entity.DiscountPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DiscountPeriodReponsitory extends JpaRepository<DiscountPeriod,Integer> {
}
