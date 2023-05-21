package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
class MobileNotificationStrategy implements NotificationStrategy {
  @Override
  public void sendIt(Advertisement advertisement) {
    log.info("Send advertisement to MOBILE CHANNEL=" + advertisement);
  }
}
