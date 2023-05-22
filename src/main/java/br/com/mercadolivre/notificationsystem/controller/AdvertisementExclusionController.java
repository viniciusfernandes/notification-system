package br.com.mercadolivre.notificationsystem.controller;

import br.com.mercadolivre.notificationsystem.exception.BusinessException;
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
  public ResponseEntity<String> excludeCustomer(@PathVariable String customerId) {
    try {
      exclusionService.excludeCustomer(customerId);
      return ResponseEntity.ok(customerId);
    } catch (BusinessException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/advertisement-exclusions/customers/{customerId}")
  public ResponseEntity<Void> cancelCustomerExclusion(@PathVariable String customerId) {
    exclusionService.cancelExclusion(customerId);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/advertisement-exclusions/customers")
  public ResponseEntity<List<String>> findExclusions() {
    return ResponseEntity.ok(exclusionService.findAllExcludedIdCustomers());
  }
}
