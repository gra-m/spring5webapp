package fun.madeby.spring5WebApp.repositories;

import fun.madeby.spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
