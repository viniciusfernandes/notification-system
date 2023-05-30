package br.com.mercadolivre.notificationsystem.model.repository;

import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;

import java.util.List;

public interface AdvertisementNotificationRepository {
  public void save(List<AdvertisementNotification> advertisements);

  List<AdvertisementNotification> findAll();

  void removerAllById(List<String> ids);
}
