package br.com.mercadolivre.notificationsystem.controller.mapper;

import br.com.mercadolivre.notificationsystem.controller.dto.AdvertisementNotificationDto;
import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementNotificationMapper {
  public static AdvertisementNotification toModel(AdvertisementNotificationDto dto) {
    return AdvertisementNotification.builder()
        .title(dto.getTitle())
        .code(dto.getCode())
        .description(dto.getDescription())
        .channel(dto.getChannel())
        .userId(dto.getUserId())
        .build();
  }

  public static List<AdvertisementNotification> toModel(List<AdvertisementNotificationDto> dtos) {
    return dtos.stream().map(dto -> toModel(dto)).collect(Collectors.toList());
  }
}
