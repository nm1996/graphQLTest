package com.nm.consumer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@EnableConfigurationProperties
@Configuration
public class GraphQLServerConfig {

    public final static String GRAPHQL_PRODUCT_SERVER = "graphQLProductServer";

    @Bean(GRAPHQL_PRODUCT_SERVER)
    public WebClient createServer(GraphQLServerProperties properties) {
        return WebClient.builder()
                .baseUrl(properties.getServerHost())
                .build();
    }
}
