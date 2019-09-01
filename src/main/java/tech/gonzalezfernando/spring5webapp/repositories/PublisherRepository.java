package tech.gonzalezfernando.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gonzalezfernando.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
