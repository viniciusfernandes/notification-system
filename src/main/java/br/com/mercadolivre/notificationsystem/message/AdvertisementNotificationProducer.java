package br.com.mercadolivre.notificationsystem.message;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.service.AdvertisementExclusionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class AdvertisementNotificationProducer {
  @Autowired
  private KafkaTemplate<String, Advertisement> notificationKafkaTemplate;
  @Value(value = "${kafka.topic.notification}")
  private String topicName;

  @Autowired
  private AdvertisementExclusionService exclusionService;

  public List<String> sendMessage(List<Advertisement> advertisements) {
    var processedAdvertisements = new ArrayList<String>();
    for (var advertisement : advertisements) {
      try {
        if (exclusionService.isCustomerExcluded(advertisement.getUserId())) {
          processedAdvertisements.add(advertisement.getCode());
          continue;
        }

      } catch (Exception e) {
        var message = String.format("Failure on checking if the user=%s was excluded from the notifications",
            advertisement.getUserId());
        log.error(message, e);
        continue;
      }
      var key = advertisement.getCode() + ":" + advertisement.getUserId();
      var future = notificationKafkaTemplate.send(topicName, key, advertisement);

      future.addCallback(new ListenableFutureCallback<>() {
        @Override
        public void onSuccess(SendResult<String, Advertisement> result) {
          var advCode = result.getProducerRecord().value().getCode();
          processedAdvertisements.add(advCode);

          log.debug("Publishing the advertisement=[" + advCode +
              "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }

        @Override
        public void onFailure(Throwable ex) {
          log.error(String.format("Unable to publish some advertisement"), ex);
        }
      });
      try {
        var sentAdvertisement = future.get().getProducerRecord().value();
        processedAdvertisements.add(sentAdvertisement.getCode());
      } catch (Exception e) {
        log.error(String.format("Unable to get the some advertisement information after its publishment in message broker"), e);
      }
    }
    return processedAdvertisements;
  }
}


