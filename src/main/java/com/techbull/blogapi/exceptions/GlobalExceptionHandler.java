package com.techbull.blogapi.exceptions;

import com.techbull.blogapi.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgsNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> map = new HashMap<>();
        System.out.println("MethodArgumentNotValidException");

        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String msg = error.getDefaultMessage();
            map.put(fieldName, msg);
        });

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> methodArgsTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Map<String, String> map = new HashMap<>();
        System.out.println("MethodArgumentTypeMismatchException " +  e.getLocalizedMessage());

        String fieldName = e.getName();
        String msg = e.getMessage();
        map.put(fieldName, msg);

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
