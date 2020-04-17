package th.ac.mahidol.ict.heroes;

import org.springframework.data.repository.CrudRepository;

public interface HeroesRepository extends CrudRepository<Hero, Integer> {
}
