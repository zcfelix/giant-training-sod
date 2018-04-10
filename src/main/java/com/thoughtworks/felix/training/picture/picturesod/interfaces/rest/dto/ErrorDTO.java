package com.thoughtworks.felix.training.picture.picturesod.interfaces.rest.dto;

public class ErrorDTO {
    private String status;
    private String message;

    public ErrorDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
