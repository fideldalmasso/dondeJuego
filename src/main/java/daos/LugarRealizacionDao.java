package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		 Transaction tx = session.beginTransaction();
		 LugarRealizacion lr = factory.openSession().get(LugarRealizacion.class, id);
		 tx.commit();
		 return lr;
	}
	
	public void saveLugarRealizacion(LugarRealizacion lr) {
		Transaction tx = session.beginTransaction();
		lr.setId((Integer) session.save(lr));
		tx.commit();
	}

}
