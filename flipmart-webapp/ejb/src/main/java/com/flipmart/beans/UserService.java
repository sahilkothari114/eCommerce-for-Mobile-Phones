package com.flipmart.beans;

import com.flipmart.service.UserServiceLocal;
import javax.ejb.Stateless;

import com.flipmart.persistence.Users;
import java.util.List;
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

    private static final Logger logger = Logger.getLogger(UserService.class);

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
        logger.info("Begining transaction");

        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        logger.info("Persisting user");
        entityManager.persist(user);

        logger.info("Persisting user success");
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
                logger.info("Valid user");
                return true;
            }
            logger.info("No such user found");
            return false;
        }
        logger.info("user object is null");
        return false;
    }

    @Override
    public Users findByUserName(String userName) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        if (userName != null) {
            Query query = entityManager.createNamedQuery("find users by first_name");
            query.setParameter("firts_name", userName);
            Users user = (Users) query.getSingleResult();

            if (user != null) {
                System.out.println("Data from backend "+user);
                return user;
            }
            logger.error("could not find details of the user");
        }
        logger.error("user name is null");
        return null;
    }

}
