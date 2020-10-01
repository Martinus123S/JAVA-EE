package del.ac.id.service.Impl;

import del.ac.id.model.ListUser;
import del.ac.id.repository.ListUserRepository;
import del.ac.id.service.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListUserServiceImpl implements ListUserService {

    @Autowired
    ListUserRepository listUserRepository;

    @Override
    public List<ListUser> findByUser(String username) {
        return listUserRepository.findAllByUsername(username);
    }

    @Override
    public void save(ListUser user) {
        listUserRepository.save(user);
    }
}
