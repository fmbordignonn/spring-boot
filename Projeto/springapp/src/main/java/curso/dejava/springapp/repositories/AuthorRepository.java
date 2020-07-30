package curso.dejava.springapp.repositories;

import curso.dejava.springapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
