package com.nm.consumer.controller;

import com.nm.consumer.dto.ProductFetchDto;
import com.nm.consumer.service.ProductFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductFetchController {

    private final ProductFetchService productFetchService;

    @GetMapping
    public ResponseEntity<List<ProductFetchDto>> getProducts() {
        List<ProductFetchDto> result = productFetchService.getAllProducts();

        return ResponseEntity.ok(result);
    }

}
