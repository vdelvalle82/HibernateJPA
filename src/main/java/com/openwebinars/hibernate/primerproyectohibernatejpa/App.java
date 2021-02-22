package com.openwebinars.hibernate.primerproyectohibernatejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrimerProyectoHibernateJPA");

		EntityManager em = emf.createEntityManager();

		User user = new User();
		user.setId(1);
		user.setUserName("Pepe");
		user.setUserMessage("Hello world JPA from Pepe");

		User user2 = new User();
		user2.setId(2);
		user2.setUserName("Javier Mateo");
		user2.setUserMessage("Hello world JPA from Juan");

		em.getTransaction().begin();
		em.persist(user);
		em.persist(user2);

		em.getTransaction().commit();

		em.close();
		emf.close();
	
    }
}
