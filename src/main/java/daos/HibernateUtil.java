package daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static EntityManagerFactory factory;
	
	public HibernateUtil() {
		 try {
	        if(factory==null) factory = Persistence.createEntityManagerFactory("DondeJuego");
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	public EntityManagerFactory getFactory() {
		return factory;
	}
	
}
