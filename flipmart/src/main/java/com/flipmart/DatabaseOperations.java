package com.flipmart;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.flipmart.dao.Color;

public class DatabaseOperations {
	private static final String PERSISTENCE_UNIT_NAME = "flipmartDB";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	public void testInsert() {
		if(!transactionObj.isActive()) {
			transactionObj.begin();
		}
		
		Color color = new Color();
		color.setColorName("Black");
		
		entityMgrObj.persist(color);
		transactionObj.commit();
	}
}
