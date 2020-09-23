package del.ac.id.repository;

import del.ac.id.model.RoleName;
import del.ac.id.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {
    Boolean existsByName(RoleName roleName);

    Roles findByName(RoleName roleName);
}
