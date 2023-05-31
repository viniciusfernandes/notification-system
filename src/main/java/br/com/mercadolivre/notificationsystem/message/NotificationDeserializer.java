package br.com.mercadolivre.notificationsystem.message;

import br.com.mercadolivre.notificationsystem.message.dto.NotificationDto;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class NotificationDeserializer extends JsonDeserializer<NotificationDto> {
}
