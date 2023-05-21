package br.com.mercadolivre.notificationsystem.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationStrategyFactory {

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  public NotificationStrategy getNotification(ChannelType channel) {
    if (ChannelType.DESKTOP == channel) {
      return new DesktopNotificationStrategy(messagingTemplate);
    } else if (ChannelType.MOBILE == channel) {
      return new MobileNotificationStrategy();
    } else if (ChannelType.EMAIL == channel) {
      return new EmailNotificationStrategy();
    }
    throw new IllegalArgumentException(
        String.format("There is no notification strategy to the channel=%s", channel));
  }
}
