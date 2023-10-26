package myweb.dao;

import myweb.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "emf")
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("From User u order by u.id ASC", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        System.out.println(user);
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
