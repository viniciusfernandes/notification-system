package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.AdvertisementExclusion;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementExclusionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvertisementExclusionHashTableRepository implements AdvertisementExclusionRepository {
  private Map<String, AdvertisementExclusion> table = new HashMap<>();

  @Override
  public void save(AdvertisementExclusion advertisementExclusion) {
    table.put(advertisementExclusion.getCustomerId(), advertisementExclusion);
  }

  @Override
  public int deleteById(String id) {
    return table.remove(id) != null ? 1 : 0;
  }

  @Override
  public AdvertisementExclusion findById(String id) {
    return table.get(id);
  }

  @Override
  public List<String> findAllExcludedIdCustomers() {
    return new ArrayList<>(table.keySet());
  }
}
