package com.flipmart.beans;

import com.flipmart.service.UserServiceLocal;
import javax.ejb.Stateless;

import com.flipmart.persistence.Users;
import java.time.Period;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Shagufta
 */
@Stateless
public class UserService implements UserServiceLocal {

    private EntityManager entityManager;
    private static EntityTransaction transactionObj;

    public UserService() {
        entityManager = Persistence.createEntityManagerFactory("flipmart")
                .createEntityManager();
        transactionObj = entityManager.getTransaction();
    }

    @Override
    public Users findByUserId(Long userId) {
        System.out.println("Find user by id");
        return null;
    }

    @Override
    public void addUser(Users user) {
        System.out.println("Add user");
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        entityManager.persist(user);

        transactionObj.commit();
    }

}
