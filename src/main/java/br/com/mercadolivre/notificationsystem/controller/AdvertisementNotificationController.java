package br.com.mercadolivre.notificationsystem.controller;

import br.com.mercadolivre.notificationsystem.exception.BusinessException;
import br.com.mercadolivre.notificationsystem.message.MessageProducer;
import br.com.mercadolivre.notificationsystem.model.Advertisement;
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
  private MessageProducer messageProducer;

  @PostMapping("/advertisement-notifications")
  public ResponseEntity<String> saveNotifications(@RequestBody List< Advertisement> advertisements) {
    try {
      messageProducer.sendMessage(advertisements);
    } catch (BusinessException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      var message = String.format("Fail on processing the advertisement=%s. Message=%s.",
          advertisements, e.getMessage());
      log.error(message, e);
      return ResponseEntity.internalServerError().body(message);
    }
    return ResponseEntity.accepted().build();
  }
}