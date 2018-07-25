package com.flipmart.beans;

import com.flipmart.service.UserServiceLocal;
import javax.ejb.Stateless;

import com.flipmart.persistence.Users;
import com.flipmart.utils.PasswordHash;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
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
        LOGGER.info("Find user by id");
        Users user = entityManager.find(Users.class, userId);

        return user;
    }

    @Override
    public void addUser(Users user) {
        try {
            LOGGER.info("Begining transaction");

            if (!transactionObj.isActive()) {
                transactionObj.begin();
            }
            String password = user.getPassword();
            password = PasswordHash.generatePasswordHash(password);

            user.setPassword(password);

            LOGGER.info("Persisting user");
            entityManager.persist(user);

            
            transactionObj.commit();
            LOGGER.info("Persisting user success");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            LOGGER.error(ex);
        }
    }

    @Override
    public Users findUserByEmailAndPassword(Users user) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        if (user != null) {
            String email = user.getEmail();
            String password = user.getPassword();

            Query query = entityManager.createNamedQuery("findUserByEmail");
            query.setParameter("email", email);

            Users result = (Users) query.getSingleResult();
            LOGGER.info("Result from database: "+result);

            if (result != null) {
                LOGGER.info ("Verifing User");
                boolean valid = verifyUser(result, password);
                if (valid) {
                    return result;
                }
            }
            LOGGER.info("No such user found");
            return null;
        }
        LOGGER.info("user object is null");
        return null;
    }

    private Boolean verifyUser(Users user, String password) {
        boolean valid = false;
        try {
            LOGGER.info ("calling password hash");
            
            String verifyPassword = user.getPassword();
            valid = PasswordHash.validatePassword(password, verifyPassword);
            
            LOGGER.info ("User valid? "+valid);
            return valid;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            LOGGER.error(ex);
        }
        return valid;
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
                System.out.println("Data from backend " + user);
                return user;
            }
            LOGGER.error("could not find details of the user");
        }
        LOGGER.error("user name is null");
        return null;
    }

}
