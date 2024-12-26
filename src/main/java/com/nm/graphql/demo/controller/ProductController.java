package com.nm.graphql.demo.controller;

import com.nm.graphql.demo.dto.ProductDto;
import com.nm.graphql.demo.entity.Product;
import com.nm.graphql.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/categories/{categoryId}")
    public List<ProductDto> getProductsByCategoryId(@PathVariable Long categoryId){
        return productService.getProductsByCategory(categoryId);
    }


    @GetMapping("/most-expensive")
    public ProductDto getMostExpensive(){
        return productService.getMostExpensive();
    }

}
