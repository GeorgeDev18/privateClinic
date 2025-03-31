package com.privateclinic.exception.handler;

import com.privateclinic.exception.error.BadRequestException;
import com.privateclinic.exception.error.ConflictException;
import com.privateclinic.exception.error.ElementNotFoundException;
import com.privateclinic.exception.error.ApiError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // --- Custom Exceptions ---

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ApiError> handleElementNotFoundException(ElementNotFoundException ex, HttpServletRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiError> handleConflictException(ConflictException ex, HttpServletRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI()), HttpStatus.CONFLICT);
    }

    // --- Validation Exceptions ---

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, errors, request.getRequestURI()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        String errors = ex.getConstraintViolations()
                .stream()
                .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, errors, request.getRequestURI()), HttpStatus.BAD_REQUEST);
    }

    // --- Catch All ---

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex, HttpServletRequest request) {
        ex.printStackT
    race();
        return new ResponseEntity<>(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.", request.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

