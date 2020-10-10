package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.Pais;

public class PaisDAO {
	private static SessionFactory factory;
	
	public PaisDAO() {
		try {
			factory = new HibernateUtil().getSession();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void save(Pais p) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		p.setId((Integer) session.save(p));
		tx.commit();
		session.close();
	}
}
