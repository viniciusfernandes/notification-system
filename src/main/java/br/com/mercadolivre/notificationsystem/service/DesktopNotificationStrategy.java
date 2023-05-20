package br.com.mercadolivre.notificationsystem.service;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class DesktopNotificationStrategy implements NotificationStrategy {

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @Override
  public void sendIt(Advertisement advertisement) {
    messagingTemplate.convertAndSend("/topic/advertisement-notifications", advertisement);
  }
}
