package com.nm.graphql.demo.mapper;

import com.nm.graphql.demo.dto.ProductDto;
import com.nm.graphql.demo.entity.Category;
import com.nm.graphql.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public ProductDto toDto(Product product){
        return new ProductDto(
                product.getName(), product.getPrice(), product.getStock(), product.getCategory().getName()
        );
    }


    public Product toEntity(ProductDto productDto){
        return new Product(
                productDto.getName(),
                productDto.getPrice(),
                productDto.getStock(),
                null
        );
    }
}
