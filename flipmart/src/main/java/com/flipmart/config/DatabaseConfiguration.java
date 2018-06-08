package com.flipmart.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.flipmart.model.ColorEntity;
import com.flipmart.util.FlipmartConstants;

public class DatabaseConfiguration {
	private static EntityManager entityMgrObj;
	private static EntityTransaction transactionObj;

	public void createEntity() {
		entityMgrObj = Persistence.createEntityManagerFactory(FlipmartConstants.PERSISTENCE_UNIT_NAME)
				.createEntityManager();

		transactionObj = entityMgrObj.getTransaction();
	}

	public void testInsert() {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}

		ColorEntity color = new ColorEntity();
		color.setColorName("Grey");

		entityMgrObj.persist(color);

		transactionObj.commit();
	}
}
