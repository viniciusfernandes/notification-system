package br.com.mercadolivre.notificationsystem.exception;

import lombok.Data;

import java.util.List;

@Data
public class RequiredFieldsException extends Exception {
  public List<String> validationMessages;

  public RequiredFieldsException(String message, List<String> messages) {
    super(message);
    this.validationMessages = validationMessages;
  }
}
