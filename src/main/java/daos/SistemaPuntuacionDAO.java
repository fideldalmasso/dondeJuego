package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dominio.Competencia;
import dominio.SistemaPuntuacion;

public class SistemaPuntuacionDAO {
	private static EntityManagerFactory factory;
	 
	 public SistemaPuntuacionDAO() {
		 try {
	        factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	 
	 public void save(SistemaPuntuacion sp) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(sp);
		 em.getTransaction().commit();
		 em.close();
	 }
}
