package myweb.dao;

import myweb.model.User;
import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public void addUser(User user);
    public User getUser(Long id);
    public void deleteUser(Long id);
    public void updateUser(User user);
}
