package com.nm.server.mapper;

import com.nm.server.dto.ProductDto;
import com.nm.server.entity.Product;
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
