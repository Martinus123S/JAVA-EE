package del.ac.id.service;

import del.ac.id.model.ListUser;

import java.util.List;

public interface ListUserService {
    List<ListUser> findByUser(String username);
    void save(ListUser user);
}
