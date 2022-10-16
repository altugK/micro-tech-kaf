package com.kafein.consumer.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomExceptionDTO {

    private String message;
    private int status;
    private String error;
    private String path;
    private Date timestamp;

}
