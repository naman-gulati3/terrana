package com.terrana.exception_handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final String EMPTY_PARAMETER_ERROR_RESPONSE = "Required field if missing or empty";

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<String> handleMissingRequiredParameter(ConstraintViolationException ex) {
    return ResponseEntity.badRequest().body(EMPTY_PARAMETER_ERROR_RESPONSE);
  }
}
