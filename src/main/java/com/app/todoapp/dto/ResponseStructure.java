package com.app.todoapp.dto;

import lombok.Data;

@Data
public class ResponseStructure <T>{
    private T data;
    private Long statusCode;
    private String message;

}
