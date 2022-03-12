package fun.madeby.spring5WebApp.repositories;

import fun.madeby.spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
