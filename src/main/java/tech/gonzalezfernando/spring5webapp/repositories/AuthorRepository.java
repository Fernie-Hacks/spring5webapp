package tech.gonzalezfernando.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gonzalezfernando.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
