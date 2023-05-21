package br.com.mercadolivre.notificationsystem.dto;

import lombok.Data;

@Data
public class AdvertisementDto {
  private final String title;
  private final String description;

  public AdvertisementDto(String title, String description) {
    this.title = title;
    this.description = description;
  }

}
