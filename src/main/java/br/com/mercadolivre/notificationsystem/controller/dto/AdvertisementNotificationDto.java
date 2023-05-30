package br.com.mercadolivre.notificationsystem.controller.dto;

import lombok.Data;

@Data
public class AdvertisementNotificationDto {
  private String code;
  private String userId;
  private String title;
  private String description;
  private String channel;
}
