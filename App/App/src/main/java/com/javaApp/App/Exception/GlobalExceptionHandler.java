package com.javaApp.App.Exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<@NonNull ErrorResponse> handleStudentNotFoundError(StudentNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<@NonNull ErrorResponse> handleAdminNotFoundError(AdminNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<@NonNull ErrorResponse> handleAnyOtherErrors(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage()
        );
        return  new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserExists(UserAlreadyExistsException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("message", ex.getMessage());
        response.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
