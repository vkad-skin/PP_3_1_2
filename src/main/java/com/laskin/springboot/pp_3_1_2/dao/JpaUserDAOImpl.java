package com.laskin.springboot.pp_3_1_2.dao;

import com.laskin.springboot.pp_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaUserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public JpaUserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.createQuery("delete from User u where u.id= :id")
                .setParameter("id", id).executeUpdate();
    }
}
