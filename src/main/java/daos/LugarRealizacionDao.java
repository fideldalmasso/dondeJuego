package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class LugarRealizacionDao {
	private static SessionFactory factory;
	private static Session session; 
	public LugarRealizacionDao() {
		 try {
	         factory = new Configuration().configure().buildSessionFactory();
	         session = factory.openSession();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	public LugarRealizacion getLugarRealizacion(Integer id) {
		 return factory.openSession().get(LugarRealizacion.class, id);
	}
	
	public void saveLugarRealizacion(LugarRealizacion lr) {
		lr.setId((Integer) session.save(lr));
	}

}
