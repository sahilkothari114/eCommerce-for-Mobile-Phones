package com.flipmart.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

		/*ColorEntity c1 = new ColorEntity();
		ColorEntity c2 = new ColorEntity();
		c1.setColorName("blue");
		c2.setColorName("purple");

		//entityMgrObj.persist(c1);
		//entityMgrObj.persist(c2);
		ManufacturerEntity manufacturer = new ManufacturerEntity();
		manufacturer.setActive(true);
		manufacturer.setName("Sony");

		/*entityMgrObj.persist(manufacturer);

		StateEntity state = new StateEntity();
		state.setStateName("Gujarat");

		entityMgrObj.persist(state);

		CityEntity city = new CityEntity();
		city.setCityName("Gandhinagar");
		city.setState(state);
		
		entityMgrObj.persist(city);*/

		/*PincodeEntity pincode = new PincodeEntity();
		pincode.setPincode(454545);
		pincode.setCity(city);
		
		entityMgrObj.persist(pincode);

		UsersEntity user = new UsersEntity();
		user.setActive(true);
		user.setContactNo("9898989898");
		user.seteMail("test@gmail.com");
		user.setFirstName("Shagufta");
		user.setLastName("Shaikh");
		user.setPassword("test");
		user.setPincode(pincode);
		
		entityMgrObj.persist(user);

		ProductEntity product = new ProductEntity();
		product.setActive(true);
		product.setCamera(2);
		product.setDescription("testing");
		product.setManufacturer(manufacturer);
		product.setModelNo("1235");
		product.setOs("AN");
		product.setProcessor("Test Processor");
		product.addColor(c1);
//		product.addColor(c2);
		product.setProductName("Phone");
		product.setPrice(2000);
		product.setRam(2);
		//product.setUser(user);
		
		entityMgrObj.persist(product);*/
		transactionObj.commit();
	}
}
