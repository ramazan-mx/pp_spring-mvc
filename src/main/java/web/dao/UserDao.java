package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(int id);
    void update(int id, User userUpdate);
    List<User> getAll();
    User getUserById(int id);
}