package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;
import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MobileNotificationStrategy implements NotificationStrategy {
  @Override
  public void sendIt(NotificationDto notification) {
    log.info("Send advertisement to MOBILE CHANNEL=" + notification);
  }
}
