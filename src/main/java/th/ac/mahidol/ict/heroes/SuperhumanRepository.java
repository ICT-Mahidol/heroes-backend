package th.ac.mahidol.ict.heroes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SuperhumanRepository extends CrudRepository<Superhuman, Integer> {
}
