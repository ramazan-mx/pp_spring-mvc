package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    public void delete(int id) {
        entityManager.remove(getUserById(id));
    }

    public void update(int id, User userUpdate) {
        User user = getUserById(id);
        user.setFirstName(userUpdate.getFirstName());
        user.setLastName(userUpdate.getLastName());
        user.setEmail(userUpdate.getEmail());
    }

    public List<User> getAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }


    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
