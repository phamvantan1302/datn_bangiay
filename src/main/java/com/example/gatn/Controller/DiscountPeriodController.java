package com.example.gatn.Controller;

import com.example.gatn.Entity.DiscountPeriod;
import com.example.gatn.Service.DiscountPeriodService;
import com.example.gatn.Service.Impl.DiscountPeriodImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class DiscountPeriodController {
    @Autowired
    DiscountPeriodService discountPeriodService = new DiscountPeriodImpl();

    @GetMapping("DiscountPeriods")
    public List<DiscountPeriod> getall(){
        return discountPeriodService.getall();
    }

    @GetMapping("DiscountPeriod/{id}")
    public DiscountPeriod getonebyid(@PathVariable("id") Integer id){
        return discountPeriodService.getonebyid(id);
    }

    @DeleteMapping("DiscountPeriod/{id}")
    public void delete(@PathVariable("id") Integer id){
         discountPeriodService.delete(id);
    }

    @PostMapping("DiscountPeriod")
    public DiscountPeriod post(@RequestBody DiscountPeriod discountPeriod){
        discountPeriodService.add(discountPeriod);
        return discountPeriod;
    }
    @PutMapping("DiscountPeriod/{id}")
    public DiscountPeriod put(@PathVariable("id") Integer id,@RequestBody DiscountPeriod newdiscountPeriod){
        DiscountPeriod old_discountperiod = discountPeriodService.getonebyid(id);
        BeanUtils.copyProperties(newdiscountPeriod,old_discountperiod);
        discountPeriodService.update(old_discountperiod);
        return old_discountperiod;
    }
}
