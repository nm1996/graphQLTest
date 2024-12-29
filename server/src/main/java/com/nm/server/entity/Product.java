package com.nm.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private Integer stock;

    @ManyToOne
    private Category category;


    public Product(String name, Float price, Integer stock, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}
