//package com.nm.graphql.demo;
//
//import com.nm.graphql.demo.entity.Category;
//import com.nm.graphql.demo.entity.Product;
//import com.nm.graphql.demo.repository.CategoryRepository;
//import com.nm.graphql.demo.repository.ProductRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Profile;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
////@Profile("dbprepare")
//@SpringBootApplication
//public class ApplicationDB {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//
//    @PostConstruct
//    public void initDB(){
//
//        Category electronics = new Category("electronics");
//        Category furniture = new Category("furniture");
//        Category stationery = new Category("stationery");
//        Category accessories = new Category("accessories");
//
//        List<Category> storedCategories = categoryRepository.saveAll(List.of(electronics, furniture, stationery, accessories));
//
//        List<Product> products = Stream.of(
//                new Product("Laptop", 74999.99f, 50, storedCategories.get(0)),
//                new Product("Smartphone", 39999.99f, 100, storedCategories.get(0)),
//                new Product("Office Chair", 7999.99f, 200, storedCategories.get(1)),
//                new Product("Notebook", 99.99f, 500, storedCategories.get(2)),
//                new Product("Desk Lamp", 1999.99f, 150, storedCategories.get(1)),
//                new Product("Watter Bottle", 499.99f, 300, storedCategories.get(3))
//        ).collect(Collectors.toList());
//
//        productRepository.saveAll(products);
//    }
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(ApplicationDB.class, args);
//    }
//}
