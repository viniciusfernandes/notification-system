package br.com.mercadolivre.notificationsystem.exception;

public class DatabaseOperationException extends Exception {
  public DatabaseOperationException(String message, Exception e) {
    super(message, e);
  }
}
