package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dominio.CompetenciaLugar;

public class CompetenciaLugarDAO {
	private static EntityManagerFactory factory;
	
	public CompetenciaLugarDAO() {
		 try {
	        factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	
	public void save(CompetenciaLugar lc) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(lc);
		 em.getTransaction().commit();
		 em.close();
	}
}
