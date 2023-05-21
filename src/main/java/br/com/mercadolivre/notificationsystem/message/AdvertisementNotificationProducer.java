package br.com.mercadolivre.notificationsystem.message;

import br.com.mercadolivre.notificationsystem.exception.BusinessException;
import br.com.mercadolivre.notificationsystem.model.Advertisement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AdvertisementNotificationProducer {
  @Autowired
  private KafkaTemplate<String, Advertisement> notificationKafkaTemplate;

  @Value(value = "${kafka.topic.notification}")
  private String topicName;

  public void sendMessage(List<Advertisement> advertisements) throws BusinessException {
    if (advertisements == null || advertisements.isEmpty()) {
      return;
    }
    var errorMessage = new ArrayList<Advertisement>();
    for (var advertisement : advertisements) {
      if (advertisement == null || !advertisement.isValid()) {
        errorMessage.add(advertisement);
      }
      var key = advertisement.getCode() + ":" + advertisement.getUserId();
      var future = notificationKafkaTemplate.send(topicName, key, advertisement);
      future.addCallback(new ListenableFutureCallback<>() {
        @Override
        public void onSuccess(SendResult<String, Advertisement> result) {
          log.debug("Publicando a notificacao=[" + advertisement.getCode() +
              "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }

        @Override
        public void onFailure(Throwable ex) {
          log.error("Unable to send message=["
              + advertisement.getCode() + "] due to : " + ex.getMessage());
        }
      });
    }
    if (!errorMessage.isEmpty()) {
      StringBuilder message = new StringBuilder("The following advertisements must be filled: ");
      errorMessage.forEach(adv -> message.append(adv).append("\n"));
      throw new BusinessException(message.toString());
    }
  }
}
