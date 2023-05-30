package br.com.mercadolivre.notificationsystem.message;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;
import br.com.mercadolivre.notificationsystem.service.AdvertisementExclusionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AdvertisementNotificationProducer {
  @Autowired
  private KafkaTemplate<String, NotificationDto> notificationKafkaTemplate;
  @Value(value = "${kafka.topic.notification}")
  private String topicName;

  @Autowired
  private AdvertisementExclusionService exclusionService;

  public List<String> sendMessage(List<NotificationDto> notifications) {
    var processedNotifications = new ArrayList<String>();
    for (var notification : notifications) {
      try {
        if (exclusionService.isCustomerExcluded(notification.getUserId())) {
          processedNotifications.add(notification.getCode());
          continue;
        }
        var key = notification.getCode() + ":" + notification.getUserId();
        notificationKafkaTemplate.send(topicName, key, notification);
      } catch (Exception e) {
        var message = String.format("Failure on checking if the user=%s was excluded from the notifications",
            notification.getUserId());
        log.error(message, e);
      }
    }
    return processedNotifications;
  }

}
