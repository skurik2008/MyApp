package myweb.service;

import myweb.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    void updateUser(User user);
}
