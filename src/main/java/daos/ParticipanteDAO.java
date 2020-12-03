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
	
	public List<Participante> getParticipantes(Integer idCompetencia){
		EntityManager em	= factory.createEntityManager();
		em.getTransaction().begin();
	    List<Participante> participantes = em.createQuery("SELECT participante from Participante participante where participante.idCompetencia = ?1")
	      .setParameter(1, idCompetencia)
	      .getResultList();
		 em.getTransaction().commit();
		 em.close();
	    return participantes;
		
	}
}
