package th.ac.mahidol.ict.heroes.repositories;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.heroes.model.Superhuman;

/***
 * A class to manage the database of Superhumans
 */
public interface SuperhumanRepository extends CrudRepository<Superhuman, Integer> {
}
