package fun.madeby.spring5WebApp.repositories;

import fun.madeby.spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
