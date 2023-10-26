package myweb.service;

import myweb.model.User;
import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public void addUser(User user);
    public User getUser(Long id);
    public void deleteUser(Long id);
}
