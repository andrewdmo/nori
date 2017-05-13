package com.norialertapp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @RequestMapping(value = "/error")
    public String error(Exception e) {
        return "error";
    }
}