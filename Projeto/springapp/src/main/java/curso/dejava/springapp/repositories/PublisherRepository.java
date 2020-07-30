package curso.dejava.springapp.repositories;

import curso.dejava.springapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
