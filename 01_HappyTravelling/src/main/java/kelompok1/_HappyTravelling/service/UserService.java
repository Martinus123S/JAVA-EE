package kelompok1._HappyTravelling.service;

import kelompok1._HappyTravelling.model.User;

public interface UserService {
    void save(User user);
    Boolean existByuser(String username);
}
