package com.nm.server.controller;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = ProductGraphQLController.class)
public class GraphQLAdvice {

    @GraphQlExceptionHandler
    public GraphQLError handleRuntimeException(RuntimeException exception){
        return GraphQLError.newError()
                .message(exception.getMessage())
                .build();
    }
}
