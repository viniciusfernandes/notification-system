package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.Advertisement;
import br.com.mercadolivre.notificationsystem.model.repository.AdvertisementRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public class AdvertisementMongoRepository implements AdvertisementRepository {

  private MongoTemplate mongoTemplate;

  public AdvertisementMongoRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public void save(List<Advertisement> advertisements) {
    for (var advert : advertisements) {
      mongoTemplate.save(advert);
    }
  }

  @Override
  public List<Advertisement> findAll() {
    return mongoTemplate.findAll(Advertisement.class);
  }

  @Override
  public void removerAllById(List<String> ids) {
    ids.forEach(id -> {
      var advertisement = new Advertisement();
      advertisement.setCode(id);
      mongoTemplate.remove(advertisement);
    });
  }
}
