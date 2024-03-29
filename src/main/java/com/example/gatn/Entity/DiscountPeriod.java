package com.example.gatn.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount_period")
public class DiscountPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "value")
    private float value;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "description")
    private String description;

    @Column(name = "star_price")
    private double starPrice;

    @Column(name = "end_price")
    private double endPrice;

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "category")
    private int category;

    @Column(name = "status")
    private int status;
}
