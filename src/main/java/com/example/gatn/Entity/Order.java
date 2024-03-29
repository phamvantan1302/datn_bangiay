package com.example.gatn.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "[order]")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_employees")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "code")
    private String code;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "use_name")
    private String useName;

    @Column(name = "email")
    private String email;

    @Column(name = "item_discount")
    private String itemDiscount;

    @Column(name = "total_money")
    private double totalMoney;

    @Column(name = "confirmed_date")
    private LocalDate confirmedDate;

    @Column(name = "ship_date")
    private LocalDate shipDate;

    @Column(name = "completion_date")
    private LocalDate completionDate;

    @Column(name = "note")
    private String note;

    @Column(name = "money_ship")
    private double moneyShip;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "date_of_payment")
    private LocalDate dateOfPayment;

    @Column(name = "last_moddified_date")
    private LocalDate lastModifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "update_flag")
    private String update;

    @Column(name = "status")
    private Integer status;
}
