package com.example.gatn.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "id_sole")
    private Sole sole;

    @ManyToOne
    @JoinColumn(name = "id_lace")
    private Lace lace;

    @ManyToOne
    @JoinColumn(name = "id_sockliner")
    private Sockliner sockliner;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "describe")
    private String describe;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "price")
    private float price;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "productDetail")
    private Set<Image> image;
}
