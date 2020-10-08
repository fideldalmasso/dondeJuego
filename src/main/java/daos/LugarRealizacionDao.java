package daos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class LugarRealizacionDao {
	private static SessionFactory factory; 
	public LugarRealizacionDao() {
		 try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	public LugarRealizacion getLugarRealizacion(Integer id) {
		 return factory.openSession().get(LugarRealizacion.class, id);
	 }

}
