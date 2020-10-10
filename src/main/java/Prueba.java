import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import daos.LocalidadDAO;
import daos.LugarRealizacionDAO;
import daos.PaisDAO;
import daos.ProvinciaDAO;
import daos.UsuarioDAO;
import dominio.Competencia;
import dominio.Deporte;
import dominio.Localidad;
import dominio.LugarRealizacion;
import dominio.Pair;
import dominio.Pais;
import dominio.Provincia;
import dominio.RegistroSesion;
import dominio.Usuario;
import dtos.CompetenciaDTO;
import enumerados.TipoDocumento;
import gestores.GestorAutenticacion;
import gestores.GestorCompetencia;

public class Prueba {
	private static SessionFactory factory; 
	   public static void main(String[] args) {
	      /*
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      */
	      Pair p = new Pair(1,1,1);
	      List<Pair> lp = new ArrayList<Pair>();
	      lp.add(p);
	      
	      PaisDAO pd = new PaisDAO();
	      ProvinciaDAO prod = new ProvinciaDAO();
	      LocalidadDAO locd =  new LocalidadDAO();
	      UsuarioDAO ud =  new UsuarioDAO();
	      LugarRealizacionDAO ld =  new LugarRealizacionDAO();
	      
	      GestorCompetencia gc = new GestorCompetencia();
	      GestorAutenticacion ga = new GestorAutenticacion();
	      
	      Pais pais = new Pais("Argentina", new ArrayList<Provincia>());
	      pd.save(pais);
	      Provincia prov =  new Provincia(pais, "Santa Fe", new ArrayList<Localidad>());
	      prod.save(prov);
	      Localidad loc = new Localidad(prov, "Santa Fe");
	      locd.save(loc);
	      
	      Usuario usr = new Usuario ("Edger",
	    		  "Dijkstra", 
	    		  "12345",
	    		  TipoDocumento.LE, 
	    		  "10", 
	    		  "dedgerarrobagmail.com", 
	    		  new ArrayList<Competencia>(),
	    		  new ArrayList<RegistroSesion>(),
	    		  new ArrayList<LugarRealizacion>(),
	    		  loc);
	      ud.save(usr);
	      ga.login("dedgerarrobagmail.com", "12345");
	      
	      Deporte dep = gc.crearDeporte("PATONAsdTFFFFvvvvO");
	      Set<Deporte> deportes = new HashSet<Deporte>();
	      deportes.add(dep);
	      
	      ld.saveLugarRealizacion(new LugarRealizacion("Nuevo Gasometro","Estadio temporal",null,deportes));
	      
	      CompetenciaDTO c = new CompetenciaDTO("ABERSFvvvvdsFFF",dep.getId(),lp,"Liga","Vale todo",false,0,3,1);
	      
	      System.out.println(gc.crearCompetencia(c).getId());
	     
	   }
	   
	   public Integer addRt(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer depId = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Competencia rt = new Competencia();
	         rt.setNombre("Basket");
	         depId = (Integer) session.save(rt); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return depId;
	   }
}
