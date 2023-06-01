package br.com.mercadolivre.notificationsystem.controller.exceptionhandler;

import br.com.mercadolivre.notificationsystem.exception.RequiredFieldsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(RequiredFieldsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleRequiredFieldsException(RequiredFieldsException ex) {
    return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage(), ex.getValidationMessages()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
    log.error(ex.getMessage(), ex);
    return ResponseEntity.internalServerError().body(new ErrorResponse(ex.getMessage() ));
  }
}
