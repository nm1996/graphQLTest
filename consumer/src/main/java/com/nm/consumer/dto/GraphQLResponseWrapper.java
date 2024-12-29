package com.nm.consumer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class GraphQLResponseWrapper<T>{

    private Map<String, T> data;


    public T getDataByFunctionName(String functionName){
        return data.get(functionName);
    }
}
