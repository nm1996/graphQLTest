package com.nm.consumer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductFetchDto {

    private String name;
    private Float price;
    private Integer stock;
    private String category;

}
