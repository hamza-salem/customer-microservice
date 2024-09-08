package com.digitinary.customer.customer_microservice.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?>
    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
