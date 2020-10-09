package daos;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		 Transaction tx = session.beginTransaction();
		 List<Competencia> lc = session.createQuery("from Competencia").list(); 
		 tx.commit();
		 return lc;
	 }
	 
	 public Deporte getDeporte(Integer id) {
		 Transaction tx = session.beginTransaction();
		 Deporte deporte =  session.get(Deporte.class, id);
		 tx.commit();
		 return deporte;
	 }
	 
	 public void saveModalidad(Modalidad m) {
		 Transaction tx = session.beginTransaction();
		 m.setId((Integer) session.save(m));
		 tx.commit();
	 }
	 
	 public void saveDeporte(Deporte d) {
		 Transaction tx = session.beginTransaction();
		 d.setId((Integer) session.save(d));
		 tx.commit();
	 }
	 
	 public void save(Competencia c) {
		 Transaction tx = session.beginTransaction();
		 c.setId((Integer) session.save(c));
		 tx.commit();
	 }
	 
}
