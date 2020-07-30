package curso.dejava.springapp.repositories;

import curso.dejava.springapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
