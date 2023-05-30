package br.com.mercadolivre.notificationsystem.service;

import br.com.mercadolivre.notificationsystem.exception.DatabaseOperationException;
import br.com.mercadolivre.notificationsystem.exception.RequiredFieldsException;
import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementNotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AdvertisementNotificationService {
  @Autowired
  private AdvertisementNotificationRepository advertisementNotificationRepository;

  public void save(List<AdvertisementNotification> advertisements) throws RequiredFieldsException {
    if (advertisements == null || advertisements.isEmpty()) {
      return;
    }
    var errorMessage = new ArrayList<String>();
    for (var advertisement : advertisements) {
      if (advertisement == null || !advertisement.isValid()) {
        errorMessage.add(advertisement.toString());
      }
    }
    if (!errorMessage.isEmpty()) {
      throw new RequiredFieldsException("The following advertisements have empty fields, but they are mandatory: ", errorMessage);
    }

    try {
      advertisementNotificationRepository.save(advertisements);
    } catch (Exception e) {
      log.error("Failure on saving the advertisement notification", e);
      new DatabaseOperationException("Failure on saving the advertisement notification", e);
    }
  }

  public List<AdvertisementNotification> findAll() {
    return advertisementNotificationRepository.findAll();
  }

  public void removeAllByIds(List<String> ids) {
    if (ids == null || ids.isEmpty()) {
      return;
    }
    advertisementNotificationRepository.removerAllById(ids);
  }
}
