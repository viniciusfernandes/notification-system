package br.com.mercadolivre.notificationsystem.controller.exceptionhandler;

import br.com.mercadolivre.notificationsystem.exception.RequiredFieldsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {
  @ExceptionHandler(RequiredFieldsException.class)
  public ResponseEntity<ErrorResponse> handleRequiredFieldsException(RequiredFieldsException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage(), ex.getValidationMessages()));
  }
}
