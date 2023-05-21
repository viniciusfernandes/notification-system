package br.com.mercadolivre.notificationsystem.message;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.notification.ChannelType;
import br.com.mercadolivre.notificationsystem.notification.NotificationStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AdvertisementNotificationListener {
  @Autowired
  private NotificationStrategyFactory strategyFactory;

  @KafkaListener(topics = "${kafka.topic.notification}",
      groupId = "${kafka.topic.groupId}", containerFactory = "advertisementKafkaListener")
  public void advertisement(Advertisement advertisement) {
    log.debug("Received Message in group record: " + advertisement);
    var channel = ChannelType.valueOf(advertisement.getChannel());

    try {
      strategyFactory.getNotification(channel).sendIt(advertisement);
    } catch (Exception e) {
      log.error(String.format("Failure on notifying the advertisement=%s", advertisement), e);
    }

  }

}
