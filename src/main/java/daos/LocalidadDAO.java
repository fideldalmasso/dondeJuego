package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.Localidad;
import dominio.Provincia;

public class LocalidadDAO {
	private static SessionFactory factory;
	
	public LocalidadDAO() {
		try {
			factory = new HibernateUtil().getSession();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void save(Localidad l) {
		Session session;
		session = factory.openSession();
		Transaction tx = session.beginTransaction();
		l.setId((Integer) session.save(l));
		tx.commit();
		session.close();
	}
}
