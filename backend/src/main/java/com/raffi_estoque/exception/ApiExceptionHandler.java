package com.raffi_estoque.exception;

import com.raffi_estoque.services.exception.ObjectNotFoundException;
import com.raffi_estoque.services.exception.SupportTicketException;

import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;



@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Invalid Arguments or Blank Fields"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleObjectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoResourceFoundException(NoResourceFoundException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(SupportTicketException.class)
    public ResponseEntity<ErrorMessage> handleSupportTicketException(SupportTicketException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
