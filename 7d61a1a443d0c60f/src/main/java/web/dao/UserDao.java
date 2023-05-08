package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void add(User user);
    User getUserById(int id);
    void updateUser(int id,User updateUser);
    void deleteUser(int id);

}
