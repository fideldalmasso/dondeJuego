package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.Provincia;

public class ProvinciaDAO {
	private static SessionFactory factory;
	
	public ProvinciaDAO() {
		try {
			factory = new HibernateUtil().getSession();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void save(Provincia p) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		p.setId((Integer) session.save(p));
		tx.commit();
		session.close();
	}
}
