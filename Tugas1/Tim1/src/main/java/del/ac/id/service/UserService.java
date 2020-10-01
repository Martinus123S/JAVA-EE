package del.ac.id.service;

import del.ac.id.model.Roles;
import del.ac.id.model.User;
import del.ac.id.repository.UserRepository;
import del.ac.id.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {

     void save(RegisterRequest request);
     Roles checkRole(String role);
     List<User> findAll();
     int findByUser(String username);

     User checkLogin(String username,String password);
}
