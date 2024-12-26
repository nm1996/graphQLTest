package com.nm.graphql.demo.controller;

import com.nm.graphql.demo.dto.ProductDto;
import com.nm.graphql.demo.entity.Product;
import com.nm.graphql.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductGraphQLController {


    private final ProductService productService;


    @QueryMapping
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @QueryMapping
    public List<ProductDto> getProductsByCategoryId(@Argument Long categoryId){
        return productService.getProductsByCategory(categoryId);
    }


    @QueryMapping
    public ProductDto getMostExpensive(){
        return productService.getMostExpensive();
    }

    @MutationMapping
    public ProductDto updateStock(@Argument Long id, @Argument Integer stock){
        return productService.updateStock(id, stock);
    }

    @MutationMapping
    public ProductDto newShipment(@Argument Long id, @Argument Integer stock){
        return productService.receiveNewShipment(id, stock);
    }

    @MutationMapping
    public ProductDto store(@Argument ProductDto product){
        return productService.store(product);
    }
}
