package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EmailNotificationStrategy implements NotificationStrategy {
  @Override
  public void sendIt(NotificationDto notification) {
    log.info("Send advertisement to EMAIL CHANNEL=" + notification);
  }
}
