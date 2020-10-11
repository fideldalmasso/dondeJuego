package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.Localidad;
import dominio.Provincia;

public class LocalidadDAO {
	private static EntityManagerFactory factory;
	
	public LocalidadDAO() {
		try {
			factory = new HibernateUtil().getFactory();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void save(Localidad l) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
}
