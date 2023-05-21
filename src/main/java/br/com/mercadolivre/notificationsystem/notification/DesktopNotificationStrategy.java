package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.notification.converter.AdvertisementConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

class DesktopNotificationStrategy implements NotificationStrategy {

  private SimpMessagingTemplate messagingTemplate;

  DesktopNotificationStrategy(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  @Override
  public void sendIt(Advertisement advertisement) {
    var advertisementDto = AdvertisementConverter.converte(advertisement);
    messagingTemplate.convertAndSend("/queue/advertisement-notifications/users/"
        + advertisement.getUserId(), advertisementDto);
  }
}
