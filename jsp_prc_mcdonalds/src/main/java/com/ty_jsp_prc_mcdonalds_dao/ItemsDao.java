package com.ty_jsp_prc_mcdonalds_dao;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_jsp_prc_mcdonalds_dto.Items;
 

public class ItemsDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public Items saveItems(Items items) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(items);
		entityTransaction.commit();

		return items;
	}
}
