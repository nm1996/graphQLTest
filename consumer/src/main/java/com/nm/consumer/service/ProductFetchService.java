package com.nm.consumer.service;


import com.nm.consumer.dto.GraphQLResponseWrapper;
import com.nm.consumer.dto.ProductFetchDto;
import com.nm.consumer.query.ProductQueryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static com.nm.consumer.config.GraphQLServerConfig.GRAPHQL_PRODUCT_SERVER;

@Slf4j
@Service
public class ProductFetchService {

    private final WebClient graphQLServer;

    @Autowired
    public ProductFetchService(@Qualifier(GRAPHQL_PRODUCT_SERVER) WebClient graphQLServer) {
        this.graphQLServer = graphQLServer;
    }


    public List<ProductFetchDto> getAllProducts() {
        return graphQLServer.post()
                .uri("graphql")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .bodyValue(ProductQueryBuilder.getAll())
                .retrieve()
                .bodyToMono((new ParameterizedTypeReference<GraphQLResponseWrapper<List<ProductFetchDto>>>() {}))
                .map(wrappedData -> wrappedData.getDataByFunctionName(ProductQueryBuilder.GET_PRODUCTS))
                .onErrorResume(throwable -> {
                    log.error("Error occurred while fetching products [message={}]", throwable.getMessage());
                    return Mono.just(Collections.emptyList());
                })
                .block();
    }
}
