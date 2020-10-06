package kelompok1._HappyTravelling.service;

import kelompok1._HappyTravelling.model.User;

public interface UserService {
    void save(User user);
    Boolean existByuser(String username);
    Boolean isSuccessLogin(String username, String password);
    User findUser(String username,String password);
}
