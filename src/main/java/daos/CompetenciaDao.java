package daos;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class CompetenciaDao {
	 private static SessionFactory factory; 
	 private static Session session;
	 
	 public CompetenciaDao() {
		 try {
	         factory = new Configuration().configure().buildSessionFactory();
	         session = factory.openSession();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 public List<Competencia> getAllCompetencias(){
		 return session.createQuery("from Competencia").list(); 
	 }
	 
	 public Deporte getDeporte(Integer id) {
		 return session.get(Deporte.class, id);
	 }
	 
	 public void saveModalidad(Modalidad m) {
		 m.setId((Integer) session.save(m));
	 }
	 
	 public void saveDeporte(Deporte d) {
		 d.setId((Integer) session.save(d));
	 }
	 
	 public void save(Competencia c) {
		 c.setId((Integer) session.save(c));
	 }
	 
}
