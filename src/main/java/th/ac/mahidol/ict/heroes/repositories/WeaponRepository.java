package th.ac.mahidol.ict.heroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.mahidol.ict.heroes.model.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
}
