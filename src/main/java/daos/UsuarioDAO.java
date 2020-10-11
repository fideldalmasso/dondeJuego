package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import dominio.Usuario;

public class UsuarioDAO {
	private static EntityManagerFactory factory;
	
	public UsuarioDAO() {
		try {
			factory = new HibernateUtil().getFactory();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public void save(Usuario usuario) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	/*
	public void update(Usuario usuario) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		factory.openSession().update(usuario);
		tx.commit();
		session.close();
	}
	*/
	public Usuario get(String email, String contrasenia) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<Usuario> usr = 
				em.createQuery("from Usuario U where U.email= :email AND U.contrasenia= :contrasenia")
				.setParameter("email", email)
				.setParameter("contrasenia", contrasenia)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return usr.get(0);
	}
}
