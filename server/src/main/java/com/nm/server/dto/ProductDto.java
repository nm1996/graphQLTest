package com.nm.server.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private Float price;
    private Integer stock;
    private String category;
}
