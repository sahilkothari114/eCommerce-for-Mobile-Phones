package com.flipmart.beans;

import com.flipmart.service.UserServiceLocal;
import javax.ejb.Stateless;

import com.flipmart.persistence.Users;
import java.time.Period;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    @Override
    public Boolean findUserByNameAndPassword(Users user) {
        if (user != null) {
            String userName = user.getFirstName();
            String password = user.getPassword();
            Query query = entityManager.createQuery("SELECT u.user_id FROM USERS u WHERE first_name = " + userName + " AND password = " + password + " ;");
            Users result = (Users) query.getSingleResult();
            
            if(result!=null)
                return true;
            
            return false;
        }
        return false;
    }

}
