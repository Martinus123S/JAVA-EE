package kelompok1._HappyTravelling.service.impl;

import kelompok1._HappyTravelling.model.User;
import kelompok1._HappyTravelling.repo.UserRepository;
import kelompok1._HappyTravelling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserService implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean existByuser(String username) {
        return userRepository.existsByUsername(username);
    }
}
