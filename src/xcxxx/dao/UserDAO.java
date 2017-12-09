package xcxxx.dao;

import xcxxx.entity.User;

public interface UserDAO {
    void add(User user);
    User find(String id);
    User find(String username, String password);
}
