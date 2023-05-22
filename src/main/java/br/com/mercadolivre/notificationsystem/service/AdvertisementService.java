package br.com.mercadolivre.notificationsystem.service;

import br.com.mercadolivre.notificationsystem.exception.BusinessException;
import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementService {
  @Autowired
  private AdvertisementRepository advertisementRepository;

  public void save(List<Advertisement> advertisements) throws BusinessException {
    if (advertisements == null || advertisements.isEmpty()) {
      return;
    }
    var errorMessage = new ArrayList<Advertisement>();
    for (var advertisement : advertisements) {
      if (advertisement == null || !advertisement.isValid()) {
        errorMessage.add(advertisement);
      }
    }
    if (!errorMessage.isEmpty()) {
      StringBuilder message = new StringBuilder("The following advertisements have empty fields, but they are mandatory: ");
      errorMessage.forEach(adv -> message.append(adv).append("\n"));
      throw new BusinessException(message.toString());
    }

    advertisementRepository.save(advertisements);
  }

  public List<Advertisement> findAll() {
    return advertisementRepository.findAll();
  }

  public void removeAllByIds(List<String> ids) {
    if (ids == null || ids.isEmpty()) {
      return;
    }
    advertisementRepository.removerAllById(ids);
  }
}
