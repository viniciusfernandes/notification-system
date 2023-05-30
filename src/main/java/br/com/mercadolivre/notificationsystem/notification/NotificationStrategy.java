package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;

public interface NotificationStrategy {
  void sendIt(NotificationDto notification);
}
