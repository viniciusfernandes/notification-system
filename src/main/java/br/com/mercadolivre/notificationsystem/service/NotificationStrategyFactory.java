package br.com.mercadolivre.notificationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationStrategyFactory {
  @Autowired
  private DesktopNotificationStrategy desktop;
  @Autowired
  private MobileNotificationStrategy mobile;
  @Autowired
  private EmailNotificationStrategy email;

  public NotificationStrategy getNotification(ChannelType channel) {
    if (ChannelType.DESKTOP == channel) {
      return desktop;
    } else if (ChannelType.MOBILE == channel) {
      return mobile;
    } else if (ChannelType.EMAIL == channel) {
      return email;
    }
    throw new IllegalArgumentException(
        String.format("There is no notification strategy to the channel=%s", channel));
  }
}
