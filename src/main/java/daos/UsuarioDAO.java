package daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import dominio.Usuario;

public class UsuarioDAO {
	private static SessionFactory factory;
	
	public UsuarioDAO() {
		try {
			factory = new HibernateUtil().getSession();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void save(Usuario usuario) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		usuario.setId((Integer) session.save(usuario));
		tx.commit();
		session.close();
	}
	
	public void update(Usuario usuario) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		factory.openSession().update(usuario);
		tx.commit();
		session.close();
	}
	
	public Usuario get(String email, String contrasenia) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Usuario> q = session.createQuery("from Usuario U where U.email= :email AND U.contrasenia= :contrasenia"); 
		q.setParameter("email", email);
		q.setParameter("contrasenia", contrasenia);
		Usuario usr = q.getResultStream().findFirst().orElse(null);
		tx.commit();
		session.close();
		return usr;
	}
}
