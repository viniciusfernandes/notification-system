package br.com.mercadolivre.notificationsystem.controller;

import br.com.mercadolivre.notificationsystem.controller.dto.AdvertisementNotificationDto;

import static br.com.mercadolivre.notificationsystem.controller.mapper.AdvertisementNotificationMapper.*;

import br.com.mercadolivre.notificationsystem.exception.RequiredFieldsException;
import br.com.mercadolivre.notificationsystem.service.AdvertisementNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AdvertisementNotificationController {
  @Autowired
  private AdvertisementNotificationService advertisementService;

  @PostMapping(value = "/advertisement-notifications", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> saveNotifications(@RequestBody List<AdvertisementNotificationDto> advertisementDtos) throws RequiredFieldsException {
    var advertisementNotifications = toModel(advertisementDtos);
    advertisementService.save(advertisementNotifications);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping(value = "/advertisement-notifications/customers/{idCustomer}")
  public ResponseEntity<String> disableCustomerNotifications(@PathVariable String idCustomer) throws RequiredFieldsException {
    var total = advertisementService.disableCustomerNotification(idCustomer);
    if (total <= 0) {
      ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }

  @PostMapping(value = "/advertisement-notifications/customers/{idCustomer}")
  public ResponseEntity<String> enableCustomerNotifications(@PathVariable String idCustomer) throws RequiredFieldsException {
    var total = advertisementService.enableCustomerNotification(idCustomer);
    return ResponseEntity.ok().build();
  }
}