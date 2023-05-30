package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementNotificationRepository;

import java.util.*;

public class AdvertisementHashTableRepository implements AdvertisementNotificationRepository {
  private Map<String, AdvertisementNotification> table = new HashMap<>();

  @Override
  public void save(List<AdvertisementNotification> advertisements) {
    for (var advert : advertisements) {
      table.put(advert.getCode(), advert);
    }
  }

  @Override
  public List<AdvertisementNotification> findAll() {
    if (table.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList<>(table.values());
  }

  @Override
  public void removerAllById(List<String> ids) {
    ids.forEach(id -> table.remove(id));
  }
}
