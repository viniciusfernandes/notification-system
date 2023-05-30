package br.com.mercadolivre.notificationsystem.message;

import br.com.mercadolivre.notificationsystem.model.AdvertisementNotification;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class AdvertisementDeserializer extends JsonDeserializer<AdvertisementNotification> {
}
