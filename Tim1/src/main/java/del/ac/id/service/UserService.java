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

    public void save(RegisterRequest request);
    public Roles checkRole(String role);
    public List<User> findAll();
}
