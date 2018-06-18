package com.flipmart.beanImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.flipmart.bean.UserManager;
import com.flipmart.eao.Users;
import com.flipmart.util.FlipmartConstants;

/**
 * @author Shagufta
 *
 */
@Stateless
public class UserManagerBean implements UserManager{
	
	@PersistenceUnit
	private EntityManager entityManager;
	private static EntityTransaction transactionObj;
	//private static EntityTransaction transactionObj;
	
	
	@PostConstruct
	public void initialize() {
		//entityManager = entityManagerFactory.createEntityManager();
		entityManager = Persistence.createEntityManagerFactory(FlipmartConstants.PERSISTENCE_UNIT_NAME)
				.createEntityManager();
		transactionObj = entityManager.getTransaction();
	}
	

	@Override
	public Users findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		//System.out.println("Add User");
		if(!transactionObj.isActive())
			transactionObj.begin();
		
	//	System.out.println("transaction");
		
		entityManager.persist(user);
		
		transactionObj.commit();
	}
	
	@PreDestroy
	public void cleanup() {
		if(entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
