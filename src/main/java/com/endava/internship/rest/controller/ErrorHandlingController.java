package com.endava.internship.rest.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ErrorHandlingController implements ErrorController {

    @RequestMapping(path = "/error")
    public HttpEntity<Resource<String>> handleError() {
        return new ResponseEntity<>(new Resource<>("Resource not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public HttpEntity<Resource<String>> handleNullPointerException(NullPointerException npe) {
        return new ResponseEntity<>(new Resource<>(npe.getStackTrace().toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}