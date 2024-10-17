package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
