package com.flipmart.beans;

import com.flipmart.service.UserServiceLocal;

import com.flipmart.persistence.Users;
import com.flipmart.utils.PasswordHash;
import com.flipmart.utils.UserValidation;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Shagufta
 */
@Stateful
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
            String userPassword = user.getPassword();

            Query query = entityManager.createNamedQuery("findUserByEmail");
            query.setParameter("email", email);

            Users result = (Users) query.getSingleResult();
            LOGGER.info("Result from database: " + result);

            if (result != null) {
                LOGGER.info("Verifing User his password: " + result.getPassword());
                boolean valid = UserValidation.verifyUser(result, userPassword);
                if (valid) {
                    Users responseUser = prepareResponseUser(result);

                    return responseUser;
                }
            }
            LOGGER.info("No such user found");
            return null;
        }
        LOGGER.info("user object is null");
        return null;
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

    private Users prepareResponseUser(Users result) {
        Users responseUser = new Users();

        responseUser.setActive(result.isActive());
        responseUser.setColorProductCart(result.getColorProductCart());
        responseUser.setContactNo(result.getContactNo());
        responseUser.setEmail(result.getEmail());
        responseUser.setFirstName(result.getFirstName());
        responseUser.setLastName(result.getLastName());
        responseUser.setStreetAddress(result.getStreetAddress());
        responseUser.setOrderList(result.getOrderList());
        responseUser.setPincode(result.getPincode());
        responseUser.setUserId(result.getUserId());

        return responseUser;
    }

    @Override
    public void updateUser(Users user) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }

        entityManager.merge(user);
        transactionObj.commit();
    }

    @Override
    public Users findByEmail(String email) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        if (email != null) {
            Query query = entityManager.createNamedQuery("findUsersByEmail");
            query.setParameter("email", email);
            Users user = (Users) query.getSingleResult();

            if (user != null) {
                System.out.println("Data from backend " + user);
                return user;
            }
            LOGGER.error("could not find details of the user");
        }
        LOGGER.error("email is null");
        return null;
    }

}
