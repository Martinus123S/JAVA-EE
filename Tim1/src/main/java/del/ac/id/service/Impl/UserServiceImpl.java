package del.ac.id.service.Impl;

import del.ac.id.model.RoleName;
import del.ac.id.model.Roles;
import del.ac.id.model.User;
import del.ac.id.repository.RoleRepository;
import del.ac.id.repository.UserRepository;
import del.ac.id.request.RegisterRequest;
import del.ac.id.service.UserService;

import java.util.List;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.Collections;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public void save(RegisterRequest request) {
        User user = new User(request.getNama(),
                request.getPassword(),
                request.getUsername());
        String rolename = RoleName.ROLE_USER.toString();
        Roles role = checkRole(rolename);
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
    }

    @Override
    public Roles checkRole(String role) {
        Roles roles;
        RoleName roleName = RoleName.ROLE_USER;
        if(role.equals(RoleName.ROLE_ADMIN.toString())){
            roleName = RoleName.ROLE_ADMIN;
        }
        roles = roleRepository.findByName(roleName);
        return roles;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
