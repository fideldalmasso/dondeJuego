package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dominio.Deporte;

public class DeporteDAO {
	private static EntityManagerFactory factory;
	
	public DeporteDAO() {
		 try {
	        factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	public void save(Deporte d) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(d);
		 em.getTransaction().commit();
		 em.close();
	}
	
	public Deporte get(Integer id) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 Deporte deporte =  em.find(Deporte.class, id);
		 em.getTransaction().commit();
		 em.close();
		 return deporte;
	}
	
	public List<Deporte> getAll(){
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 List<Deporte> lc = em.createQuery("from Deporte").getResultList();
		 em.getTransaction().commit();
		 em.close();
		 return lc;
	 }
}
