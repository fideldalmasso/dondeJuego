package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class LugarRealizacionDAO {
	private static EntityManagerFactory factory;
	public LugarRealizacionDAO() {
		 try {
			 factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	public LugarRealizacion get(Integer id) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		LugarRealizacion lr = em.find(LugarRealizacion.class,id);
		em.getTransaction().commit();
		em.close();
		return lr;
	}
	
	public void save(LugarRealizacion lr) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lr);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<LugarRealizacion> getAll(){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<LugarRealizacion> lr = em.createQuery("from LugarRealizacion").getResultList();
		em.getTransaction().commit();
		em.close();
		return lr;
	}

}
