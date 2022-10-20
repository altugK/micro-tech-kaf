package com.kafein.producer.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
/**
 *  Hata deseni.
 */
@Data
@AllArgsConstructor
public class CustomExceptionDTO {

    private String message;
    private int status;
    private String error;
    private String path;
    private Date timestamp;

}
