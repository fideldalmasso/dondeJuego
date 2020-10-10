package daos;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dominio.*;

public class CompetenciaDAO {
	 private static SessionFactory factory; 
	 
	 public CompetenciaDAO() {
		 try {
	        factory = new HibernateUtil().getSession();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 public List<Competencia> getAllCompetencias(){
		 Session session	= factory.openSession();
		 Transaction tx = session.beginTransaction();
		 List<Competencia> lc = session.createQuery("from Competencia").list(); 
		 tx.commit();
		 session.close();
		 return lc;
	 }
	 
	 public Deporte getDeporte(Integer id) {
		Session session	= factory.openSession();
		Transaction tx = session.beginTransaction();
		Deporte deporte =  session.get(Deporte.class, id);
		tx.commit();
		session.close();
		return deporte;
	 }
	 
	 public void saveModalidad(Modalidad m) {
		Session session	= factory.openSession();
		Transaction tx = session.beginTransaction();
		m.setId((Integer) session.save(m));
		tx.commit();
		session.close();
	 }
	 
	 public void saveDeporte(Deporte d) {
		Session session	= factory.openSession();
		Transaction tx = session.beginTransaction();
		d.setId((Integer) session.save(d));
		tx.commit();
		session.close();
	 }
	 
	 public void save(Competencia c) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		c.setId((Integer) session.save(c));
		tx.commit();
		session.close();
	 }
	 public void update(Competencia c) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
	 }
	 public void save(CompetenciaLugar lc) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		lc.setId((Integer) session.save(lc));
		tx.commit();
		session.close();
	 }
	 public List<Deporte> getAllDeportes(){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Deporte> lc = session.createQuery("from Deporte").list(); 
		tx.commit();
		session.close();
		return lc;
	 }
}
