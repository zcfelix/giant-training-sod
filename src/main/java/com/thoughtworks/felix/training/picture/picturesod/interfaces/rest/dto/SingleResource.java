package com.thoughtworks.felix.training.picture.picturesod.interfaces.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SingleResource<T> {
    private T data;
    private String url;

    public T getData() {
        return data;
    }
}
