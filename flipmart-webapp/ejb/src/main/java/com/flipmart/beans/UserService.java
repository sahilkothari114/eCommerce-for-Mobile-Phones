package com.flipmart.beans;

import com.flipmart.service.UserServiceLocal;
import javax.ejb.Stateless;

import com.flipmart.persistence.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Shagufta
 */
@Stateless
public class UserService implements UserServiceLocal {

    private final EntityManager entityManager;
    private static EntityTransaction transactionObj;

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

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
        LOGGER.info("Begining transaction");

        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        LOGGER.info("Persisting user");
        entityManager.persist(user);

        LOGGER.info("Persisting user success");
        transactionObj.commit();
    }

    @Override
    public Boolean findUserByNameAndPassword(Users user) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        if (user != null) {
            String userName = user.getFirstName();
            String password = user.getPassword();
            Query query = entityManager.createQuery("SELECT u.user_id FROM USERS u WHERE first_name = " + userName + " AND password = " + password + " ;");
            Users result = (Users) query.getSingleResult();

            if (result != null) {
                LOGGER.info("Valid user");
                return true;
            }
            LOGGER.info("No such user found");
            return false;
        }
        LOGGER.info("user object is null");
        return false;
    }

    @Override
    public Users findByUserName(String userName) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        if (userName != null) {
            Query query = entityManager.createNamedQuery("findUsersByFirstName");
            query.setParameter("firstName", userName);
            Users user = (Users) query.getSingleResult();

            if (user != null) {
                System.out.println("Data from backend "+user);
                return user;
            }
            LOGGER.error("could not find details of the user");
        }
        LOGGER.error("user name is null");
        return null;
    }

}
