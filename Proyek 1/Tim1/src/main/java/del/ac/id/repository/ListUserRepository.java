package del.ac.id.repository;

import del.ac.id.model.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListUserRepository extends JpaRepository<ListUser,Long> {
    List<ListUser> findAllByUsername(String username);
}
