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
	 
	 public Deporte getDeporte(Integer id) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 Deporte deporte =  em.find(Deporte.class, id);
		 em.getTransaction().commit();
		 em.close();
		 return deporte;
	 }
	 
	 public void saveModalidad(Modalidad m) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(m);
		 em.getTransaction().commit();
		 em.close();
	 }
	 
	 public void saveDeporte(Deporte d) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(d);
		 em.getTransaction().commit();
		 em.close();
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
	 public void save(CompetenciaLugar lc) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(lc);
		 em.getTransaction().commit();
		 em.close();
	 }
	 public List<Deporte> getAllDeportes(){
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 List<Deporte> lc = em.createQuery("from Deporte").getResultList();
		 em.getTransaction().commit();
		 em.close();
		 return lc;
	 }
}
