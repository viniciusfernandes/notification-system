package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.AdvertisementExclusion;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementExclusionRepository;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvertisementExclusionHashTableRepository implements AdvertisementExclusionRepository {
  private final Map<String, AdvertisementExclusion> table = new HashMap<>();

  @Override
  public void save(AdvertisementExclusion advertisementExclusion) {
    table.put(advertisementExclusion.getCustomerId(), advertisementExclusion);
  }

  @Override
  public int deleteById(String id) {
    return table.remove(id) != null ? 1 : 0;
  }

  @Override
  @Cacheable(value = "${redis.cache.exclusion-customer}")
  public AdvertisementExclusion findById(String id) {
    System.out.println("id customer: " + id);
    return table.get(id);
  }

  @Override
  public List<String> findAllExcludedIdCustomers() {
    return new ArrayList<>(table.keySet());
  }
}
