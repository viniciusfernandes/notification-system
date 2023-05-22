package br.com.mercadolivre.notificationsystem.model.repository;

import br.com.mercadolivre.notificationsystem.model.Advertisement;

import java.util.List;

public interface AdvertisementRepository {
  public void save(List<Advertisement> advertisements);

  List<Advertisement> findAll();

  void removerAllById(List<String> ids);
}
