package com.nm.consumer.query;


public class ProductQueryBuilder {

    public final static String GET_PRODUCTS = "getProducts";
    public final static String GET_BY_ID = "getProduct";

    public static String getAll() {
        return "{ \"query\": \"{ getProducts { category name price stock } }\" }";
    }

    public static String getById(Long id) {
        return "{ \"query\": \"{ getProduct(id: " + id + ") { category name price stock } }\" }";
    }

}
