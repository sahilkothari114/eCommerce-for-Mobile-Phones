package com.flipmart.beans;

import com.flipmart.persistence.Admin;
import com.flipmart.service.AdminServiceLocal;
import com.flipmart.utils.UserValidation;
import javax.ejb.Stateless;
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
public class AdminService implements AdminServiceLocal {

    private final EntityManager entityManager;
    private static EntityTransaction transactionObj;

    private static final Logger LOGGER = Logger.getLogger(AdminService.class);

    public AdminService() {
        entityManager = Persistence.createEntityManagerFactory("flipmart")
                .createEntityManager();
        transactionObj = entityManager.getTransaction();
    }

    @Override
    public Admin findAdminByEmailAndPassword(Admin admin) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
        if (admin != null) {
            String email = admin.getEmail();
            String userPassword = admin.getPassword();

            Query query = entityManager.createNamedQuery("findAdminByEmail");
            query.setParameter("email", email);

            Admin result = (Admin) query.getSingleResult();
            LOGGER.info("Result from database: " + result);

            if (result != null) {
                LOGGER.info("Verifing User his password: " + result.getPassword());
                boolean valid = UserValidation.verifyUser(result, userPassword);
                if (valid) {
                    Admin responseUser = prepareResponseAdmin(result);

                    return responseUser;
                }
            }
            LOGGER.info("No such user found");
            return null;
        }
        LOGGER.info("user object is null");
        return null;
    }

    private Admin prepareResponseAdmin(Admin result) {
        Admin responseAdmin = new Admin();

        responseAdmin.setActive(result.isActive());
        responseAdmin.setContactNo(result.getContactNo());
        responseAdmin.setEmail(result.getEmail());
        responseAdmin.setFirstName(result.getFirstName());
        responseAdmin.setLastName(result.getLastName());
        responseAdmin.setStreetAddress(result.getStreetAddress());
        responseAdmin.setPincode(result.getPincode());
        responseAdmin.setAdminId(result.getAdminId());

        return responseAdmin;
    }

}
