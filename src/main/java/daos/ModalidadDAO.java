package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dominio.Modalidad;

public class ModalidadDAO {
	private static EntityManagerFactory factory;
		
	public ModalidadDAO() {
		 try {
	        factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	
	public void saveModalidad(Modalidad m) {
		EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(m);
		 em.getTransaction().commit();
		 em.close();
	}
}
