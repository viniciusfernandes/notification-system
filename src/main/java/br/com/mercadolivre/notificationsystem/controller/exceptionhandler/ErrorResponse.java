package br.com.mercadolivre.notificationsystem.controller.exceptionhandler;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class ErrorResponse {
  private String message;
  private List<String> errors;

  public ErrorResponse(String message, List<String> errors) {
    this.message = message;
    this.errors = errors;
  }
}
