package del.ac.id.repository;

import del.ac.id.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "Select * from users inner join user_role " +
            "on users.username = user_role.users_id inner join " +
            "roles on user_role.role_id = roles.id",
    nativeQuery = true)
    List<User> findAll();

    User findAllByUsername(String username);
    User findAllByUsernameAndPassword(String username,String password);
}
