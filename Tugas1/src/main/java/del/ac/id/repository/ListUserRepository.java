package del.ac.id.repository;

import del.ac.id.model.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListUserRepository extends JpaRepository<ListUser,Long> {
    List<ListUser> findAllByUsername(String username);
}
