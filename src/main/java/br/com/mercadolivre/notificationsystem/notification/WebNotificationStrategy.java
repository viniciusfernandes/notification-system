package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.notification.converter.AdvertisementConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;

class WebNotificationStrategy implements NotificationStrategy {

  private SimpMessagingTemplate messagingTemplate;

  WebNotificationStrategy(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  @Override
  public void sendIt(Advertisement advertisement) {
    var advertisementDto = AdvertisementConverter.converte(advertisement);
    messagingTemplate.convertAndSend("/queue/advertisement-notifications/users/"
        + advertisement.getUserId(), advertisementDto);
  }
}
