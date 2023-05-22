package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.AdvertisementExclusion;

import java.util.List;

public interface AdvertisementExclusionRepository {
  void save(AdvertisementExclusion advertisementExclusion);

  void deleteById(String id);

  AdvertisementExclusion findById(String id);

  List<String> findAllExcludedIdCustomers();

}
