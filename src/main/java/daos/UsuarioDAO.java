package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.Usuario;

public class UsuarioDAO {
	private static SessionFactory factory;
	private static Session session;
	
	public UsuarioDAO() {
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	         session = factory.openSession();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void saveUsuario(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		factory.openSession().save(usuario);
		tx.commit();
	}
}
