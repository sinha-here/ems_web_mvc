package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;


@Component
public class DbConfig {

	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction et;
	
	
	public DbConfig() {
			emf = Persistence.createEntityManagerFactory("ems_web");
			em = emf.createEntityManager();
			et = em.getTransaction();
	}
}
