package th.ac.mahidol.ict.heroes.repositories;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.heroes.model.Superhuman;

public interface SuperhumanRepository extends CrudRepository<Superhuman, Integer> {
}
