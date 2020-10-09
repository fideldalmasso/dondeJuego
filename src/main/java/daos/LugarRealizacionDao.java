package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		 Session session;
         session = factory.openSession();		 
		 Transaction tx = session.beginTransaction();
		 LugarRealizacion lr = factory.openSession().get(LugarRealizacion.class, id);
		 tx.commit();
		 return lr;
	}
	
	public void saveLugarRealizacion(LugarRealizacion lr) {
		Session session;
        session = factory.openSession();
		Transaction tx = session.beginTransaction();
		lr.setId((Integer) session.save(lr));
		tx.commit();
	}
	
	public List<LugarRealizacion> getAllLugarRealizacion(){
		Session session;
	 session = factory.openSession();
	 Transaction tx = session.beginTransaction();
	 List<LugarRealizacion> lc = session.createQuery("from LugarRealizacion").list(); 
	 tx.commit();
	 session.close();
	 return lc;
 }

}
