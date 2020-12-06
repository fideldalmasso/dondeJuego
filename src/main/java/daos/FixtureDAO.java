package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import dominio.Fixture;

public class FixtureDAO {
	private static EntityManagerFactory factory;
	public FixtureDAO() {
		try {
			factory = new HibernateUtil().getFactory();
	    } catch (Throwable ex) { 
	         System.err.println("Fallo al crear objeto sessionFactory" + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public Fixture getFixture(Integer id){
		EntityManager em	= factory.createEntityManager();
		em.getTransaction().begin();
		Fixture fixture  = em.find(Fixture.class, id);
		em.getTransaction().commit();
		em.close();
		return fixture;
	}

}
