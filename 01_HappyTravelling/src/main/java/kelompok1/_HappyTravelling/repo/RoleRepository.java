package kelompok1._HappyTravelling.repo;

import kelompok1._HappyTravelling.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Boolean existsByRoleName(String rolename);
}
