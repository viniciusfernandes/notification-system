package br.com.mercadolivre.notificationsystem.repository;

import br.com.mercadolivre.notificationsystem.model.AdvertisementExclusion;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementExclusionMongoRepository implements AdvertisementExclusionRepository {
  private MongoTemplate mongoTemplate;

  public AdvertisementExclusionMongoRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public void save(AdvertisementExclusion advertisementExclusion) {
    mongoTemplate.save(advertisementExclusion);
  }

  @Override
  public void deleteById(String id) {
  }

  @Override
  public AdvertisementExclusion findById(String id) {
    return null;
  }

  @Override
  public List<String> findAllExcludedIdCustomers() {
    var ids = new ArrayList<String>();
    mongoTemplate.findAll(AdvertisementExclusion.class).forEach(exclusion -> ids.add(exclusion.getCustomerId()));
    return ids;
  }
}
