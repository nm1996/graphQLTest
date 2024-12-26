package com.nm.graphql.demo.service;

import com.nm.graphql.demo.dto.ProductDto;
import com.nm.graphql.demo.entity.Category;
import com.nm.graphql.demo.entity.Product;
import com.nm.graphql.demo.mapper.ProductMapper;
import com.nm.graphql.demo.repository.CategoryRepository;
import com.nm.graphql.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper mapper;


    public List<ProductDto> getProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ProductDto> getProductsByCategory(Long category) {
        return repository.findByCategoryId(category)
                .stream()
                .map(mapper::toDto)
                .toList();
    }


    public ProductDto getMostExpensive() {
        Product product = repository.findMostExpensive()
                .orElseThrow(() -> new RuntimeException("There is no most expensive product."));

        return mapper.toDto(product);
    }

    public ProductDto updateStock(Long id, Integer stock) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));
        product.setStock(stock);

        return mapper.toDto(repository.save(product));
    }


    public ProductDto receiveNewShipment(Long id, Integer quantity) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found."));
        Integer newQuantity = product.getStock() + quantity;
        product.setStock(newQuantity);

        return mapper.toDto(repository.save(product));
    }

    public ProductDto store(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        Category category = categoryRepository.findByName(dto.getCategory())
                .orElseThrow(() -> new RuntimeException("Category which is provided not exists in system."));

        product.setCategory(category);
        return mapper.toDto(repository.save(product));
    }
}
