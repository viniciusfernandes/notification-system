package br.com.mercadolivre.notificationsystem.notification;

import br.com.mercadolivre.notificationsystem.model.Advertisement;

public interface NotificationStrategy {
  void sendIt(Advertisement advertisement);
}
