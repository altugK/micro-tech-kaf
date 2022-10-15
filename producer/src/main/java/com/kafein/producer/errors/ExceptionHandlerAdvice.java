package com.kafein.producer.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<Object> handleConflict(CustomException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>(
                new CustomExceptionDTO(
                        ex.getMessage(),
                        Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).value(),
                        Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).getReasonPhrase(),
                        request.getDescription(false),
                        new Date()
                ),
                headers,
                Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }
}