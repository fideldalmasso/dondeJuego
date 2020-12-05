package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dominio.Encuentro;

public class EncuentroDAO {
	private static EntityManagerFactory factory;
	public EncuentroDAO() {
		 try {
	        factory = new HibernateUtil().getFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	 }
	public Encuentro getEncuentro(Integer id){
		EntityManager em	= factory.createEntityManager();
		em.getTransaction().begin();
		Encuentro encuentro  = em.find(Encuentro.class, id);
		em.getTransaction().commit();
		em.close();
		return encuentro;
	}
	

}
