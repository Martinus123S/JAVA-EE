package kelompok1._HappyTravelling.repo;

import kelompok1._HappyTravelling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByUsername(String username);
    User findByUsername(String username);
    Boolean existsByUsernameAndPassword(String username,String password);

    User findByUsernameAndPassword(String username,String password);
}
