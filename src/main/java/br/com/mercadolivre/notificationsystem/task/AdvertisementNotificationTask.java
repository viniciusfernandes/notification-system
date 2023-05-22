package br.com.mercadolivre.notificationsystem.task;

import br.com.mercadolivre.notificationsystem.message.AdvertisementNotificationProducer;
import br.com.mercadolivre.notificationsystem.service.AdvertisementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AdvertisementNotificationTask {
  @Autowired
  private AdvertisementService advertisementService;
  @Autowired
  private AdvertisementNotificationProducer notificationProducer;

  @Scheduled(cron = "${notification.cron}")
  public void sendAdvertisements() {
    var advertisements = advertisementService.findAll();
    var advertisementIds = notificationProducer.sendMessage(advertisements);
    advertisementService.removeAllByIds(advertisementIds);
  }
}
