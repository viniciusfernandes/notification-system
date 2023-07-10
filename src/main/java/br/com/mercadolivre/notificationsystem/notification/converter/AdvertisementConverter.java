package br.com.mercadolivre.notificationsystem.notification.converter;

import br.com.mercadolivre.notificationsystem.dto.AdvertisementDto;
import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;

public class AdvertisementConverter {
  public static AdvertisementDto converte(NotificationDto notification) {
    return new AdvertisementDto(notification.getTitle(), notification.getDescription());
  }

}
