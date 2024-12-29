package com.nm.consumer.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "target.server")
@Configuration
public class GraphQLServerProperties {

    private String host = "http://localhost";
    private int port = 8000;


    public String getServerHost() {
        return host + ":" + port;
    }
}
