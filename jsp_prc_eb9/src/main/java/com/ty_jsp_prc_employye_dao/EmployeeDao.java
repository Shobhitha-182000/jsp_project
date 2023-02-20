package com.ty_jsp_prc_employye_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_jsp_prc_employye.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	//to save
	public Employee savEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	
	//to login
	public Employee getEmployyebyemail(String email) {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e where e.email=?1");
		query.setParameter(1, email);
		Employee employee=(Employee)query.getSingleResult();
		 return employee;
	}
	
	//get All
	public List<Employee> getAll(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e ");
		List<Employee> employees=query.getResultList();
		return employees;
		
	}
	//to delete
	public boolean deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee employee=entityManager.find(Employee.class ,id);
		 
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		else 
			return false;
		 
	}
	
	//to update
	public Employee getEmployeeById(int id) {
		return getEntityManager().find(Employee.class, id);
	}
	//to update 
	public Employee updateEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
	}
	
	
	
	
	
	
	
	
	
	
	
}
