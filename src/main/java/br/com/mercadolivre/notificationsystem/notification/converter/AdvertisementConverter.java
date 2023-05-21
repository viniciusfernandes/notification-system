package br.com.mercadolivre.notificationsystem.notification.converter;

import br.com.mercadolivre.notificationsystem.dto.AdvertisementDto;
import br.com.mercadolivre.notificationsystem.model.Advertisement;

public class AdvertisementConverter {
  public static AdvertisementDto converte(Advertisement advertisement) {
    return new AdvertisementDto(advertisement.getTitle(), advertisement.getDescription());
  }

}
