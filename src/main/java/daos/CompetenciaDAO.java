package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class CompetenciaDAO {
	private static EntityManagerFactory factory;
	 
	 public CompetenciaDAO() {
		 try {
	        factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 
	 public List<Competencia> getAllCompetencias(){
		 EntityManager em	= factory.createEntityManager();
		 em.getTransaction().begin();
		 List<Competencia> lc = em.createQuery("from Competencia").getResultList(); 
		 em.getTransaction().commit();
		 em.close();
		 return lc;
	 }
	 
	 public void save(Competencia c) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(c);
		 em.getTransaction().commit();
		 em.close();
	 }
	 /*
	 public void update(Competencia c) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
	 }
	 */
	 
}
