package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        return entityManager.createQuery(jpql, User.class).getResultList();
    }


    @Transactional
    @Override
    public void add(User user) {
        entityManager.merge(user);
    }


    @Transactional
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }


    @Transactional
    @Override
    public void updateUser(int id, User updateUser) {
       User userToBeUpdated = getUserById(id);
       userToBeUpdated.setFirstName(updateUser.getFirstName());
       userToBeUpdated.setLastName(updateUser.getLastName());
       userToBeUpdated.setEmail(updateUser.getEmail());

    }


    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
}
