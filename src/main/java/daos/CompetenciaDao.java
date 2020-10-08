package daos;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class CompetenciaDao {
	 private static SessionFactory factory; 
	 public CompetenciaDao() {
		 try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 public List<Competencia> getAllCompetencias(){
		 Session session = factory.openSession();
		 return session.createQuery("from Competencia").list(); 
	 }
	 
	 public Deporte getDeporte(Integer id) {
		 return factory.openSession().get(Deporte.class, id);
	 }
	 public Integer save(Competencia c) {
		 return (Integer) factory.openSession().save(c);
	 }
}
