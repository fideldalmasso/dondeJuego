package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class ParticipanteDAO {
	private static EntityManagerFactory factory;
	public ParticipanteDAO() {
		try {
			factory = new HibernateUtil().getFactory();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	
	public Boolean verificarExistenciaNombre(String nombre, Integer idCompetencia) {
		List<Participante> p1, p2;
		EntityManager em	= factory.createEntityManager();
		em.getTransaction().begin();
	    p1= em.createQuery("SELECT participante from Participante participante where participante.competencia.id = ?1 and participante.nombre = ?2")
	      .setParameter(1, idCompetencia)
	      .setParameter(2, nombre)
	      .getResultList();

	    return (!p1.isEmpty());
	}
	
	public Boolean verificarExistenciaMail(Integer idCompetencia, String email) {
		List<Participante> p1, p2;
		EntityManager em	= factory.createEntityManager();
		em.getTransaction().begin();
	    p2= em.createQuery("SELECT participante from Participante participante where participante.competencia.id = ?1 and participante.email = ?2")
	      .setParameter(1, idCompetencia)
	      .setParameter(2, email)
	      .getResultList();
		 em.getTransaction().commit();
		 em.close();
	    return (!p2.isEmpty());
	}
}
