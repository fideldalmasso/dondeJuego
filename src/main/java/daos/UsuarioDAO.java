package daos;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dominio.Usuario;

public class UsuarioDAO {
	public void guardar (Usuario usuario) {
		SessionFactory factory;
		try {
	         factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
		
		factory.openSession().save(usuario);
	}
}
