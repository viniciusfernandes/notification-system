package br.com.mercadolivre.notificationsystem.message.mapper;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;
import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;

import java.util.List;
import java.util.stream.Collectors;

public class NotificationMapper {
  public static NotificationDto toDto(AdvertisementNotification model) {
    return new NotificationDto(model.getCode(), model.getUserId(), model.getTitle(),
        model.getDescription(), model.getChannel());
  }

  public static List<NotificationDto> toDto(List<AdvertisementNotification> models) {
    return models.stream().map(model -> new NotificationDto(model.getCode(), model.getUserId(), model.getTitle(),
        model.getDescription(), model.getChannel())).collect(Collectors.toList());
  }
}
