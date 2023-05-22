package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementRepository;

import java.util.*;

public class AdvertisementHashTableRepository implements AdvertisementRepository {
  private Map<String, Advertisement> table = new HashMap<>();

  @Override
  public void save(List<Advertisement> advertisements) {
    for (var advert : advertisements) {
      table.put(advert.getCode(), advert);
    }
  }

  @Override
  public List<Advertisement> findAll() {
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
