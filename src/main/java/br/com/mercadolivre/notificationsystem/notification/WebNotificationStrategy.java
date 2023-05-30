package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;
import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;
import br.com.mercadolivre.notificationsystem.notification.converter.AdvertisementConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;

class WebNotificationStrategy implements NotificationStrategy {

  private SimpMessagingTemplate messagingTemplate;

  WebNotificationStrategy(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  @Override
  public void sendIt(NotificationDto notification) {
    var advertisementDto = AdvertisementConverter.converte(notification);
    messagingTemplate.convertAndSend("/queue/advertisement-notifications/users/"
        + notification.getUserId(), advertisementDto);
  }
}
