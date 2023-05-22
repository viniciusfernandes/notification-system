package br.com.mercadolivre.notificationsystem.service;

import br.com.mercadolivre.notificationsystem.exception.BusinessException;
import br.com.mercadolivre.notificationsystem.model.AdvertisementExclusion;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementExclusionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementExclusionService {
  @Autowired
  private AdvertisementExclusionRepository exclusionRepository;

  public void excludeCustomer(String customerId) throws BusinessException {
    if (customerId == null || customerId.isBlank()) {
      throw new BusinessException("To exclude an user from the advertisements you should send a nonempty custonerId");
    }

    var exclusion = AdvertisementExclusion.builder().customerId(customerId).build();
    exclusionRepository.save(exclusion);
  }

  public void cancelExclusion(String customerId) {
    if (customerId == null || customerId.isBlank()) {
      return;
    }
    exclusionRepository.deleteById(customerId);
  }

  public boolean isCustomerExcluded(String customerId) {
    return exclusionRepository.findById(customerId) != null;
  }

  public List<String> findAllExcludedIdCustomers() {
    return exclusionRepository.findAllExcludedIdCustomers();
  }
}
