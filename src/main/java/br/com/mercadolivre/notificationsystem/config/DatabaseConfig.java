package br.com.mercadolivre.notificationsystem.config;

import br.com.mercadolivre.notificationsystem.repository.AdvertisementExclusionHashTableRepository;
import br.com.mercadolivre.notificationsystem.repository.AdvertisementExclusionMongoRepository;
import br.com.mercadolivre.notificationsystem.repository.AdvertisementExclusionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DatabaseConfig {
  @Value("${database.strategy}")
  private String database;

  @Bean
  public AdvertisementExclusionRepository advertisementExclusionRepository(MongoTemplate mongoTemplate) {
    if (database.equals("MONGODB")) {
      return new AdvertisementExclusionMongoRepository(mongoTemplate);
    }
    return new AdvertisementExclusionHashTableRepository();
  }
}
