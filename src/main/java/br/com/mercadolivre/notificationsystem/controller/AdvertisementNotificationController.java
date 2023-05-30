package br.com.mercadolivre.notificationsystem.controller;

import br.com.mercadolivre.notificationsystem.controller.dto.AdvertisementNotificationDto;

import static br.com.mercadolivre.notificationsystem.controller.mapper.AdvertisementNotificationMapper.*;

import br.com.mercadolivre.notificationsystem.exception.RequiredFieldsException;
import br.com.mercadolivre.notificationsystem.service.AdvertisementNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AdvertisementNotificationController {
  @Autowired
  private AdvertisementNotificationService advertisementService;

  @PostMapping("/advertisement-notifications")
  public ResponseEntity<String> saveNotifications(@RequestBody List<AdvertisementNotificationDto> advertisementDtos) throws RequiredFieldsException {
    var advertisementNotifications = toModel(advertisementDtos);
    advertisementService.save(advertisementNotifications);
    return ResponseEntity.accepted().build();
  }
}