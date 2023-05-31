package br.com.mercadolivre.notificationsystem.controller;

import br.com.mercadolivre.notificationsystem.exception.RequiredFieldsException;
import br.com.mercadolivre.notificationsystem.service.AdvertisementExclusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertisementExclusionController {
  @Autowired
  private AdvertisementExclusionService exclusionService;

  @PostMapping("/advertisement-exclusions/customers/{customerId}")
  public ResponseEntity<String> excludeCustomer(@PathVariable String customerId) throws RequiredFieldsException {
    exclusionService.excludeCustomer(customerId);
    return ResponseEntity.accepted().build();
  }

  @DeleteMapping("/advertisement-exclusions/customers/{customerId}")
  public ResponseEntity<Void> cancelCustomerExclusion(@PathVariable String customerId) throws RequiredFieldsException {
    int total = exclusionService.cancelExclusion(customerId);
    if (total <= 0) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.accepted().build();
  }

  @GetMapping("/advertisement-exclusions/customers")
  public ResponseEntity<List<String>> findExclusions() {
    return ResponseEntity.ok(exclusionService.findAllExcludedIdCustomers());
  }
}
