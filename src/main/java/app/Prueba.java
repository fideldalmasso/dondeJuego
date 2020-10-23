package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
import gui.Gui;

public class Prueba {
	
	public static void main(String[] args) {
	      /*
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      */
	      
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
	      
	      /*Usuario usr = new Usuario ("EdgefsddrsaadAhsfssasafafsgrr",
	    		  "Dijkstra", 
	    		  "12345",
	    		  TipoDocumento.LE, 
	    		  "10", 
	    		  "dedgerarrobagmail.com", 
	    		  new HashSet<Competencia>(),
	    		  new HashSet<RegistroSesion>(),
	    		  new HashSet<LugarRealizacion>(),
	    		  loc);
	      ud.save(usr);
	      */
	      ga.login("dedgerarrobagmail.com", "12345");
	      
	      Deporte dep = gc.crearDeporte("PATONfAdsdTaFhsasFdFafaAsssffsFdgasavvvvO");
	      Set<Deporte> deportes = new HashSet<Deporte>();
	      deportes.add(dep);
	      
	      LugarRealizacion lr = new LugarRealizacion("Nuevo Gasometro","Estadio temporal",null,deportes);
	      ld.save(lr);
	      
	      Pair p = new Pair(lr.getId(),1);
	      List<Pair> lp = new ArrayList<Pair>();
	      lp.add(p);
	      
	      CompetenciaDTO c = new CompetenciaDTO(
	    		  "ABEfRSdFsvsasadsvhaavvdssFFF",
	    		  dep.getId(),
	    		  lp,
	    		  "Liga",
	    		  "Vale todo",
	    		  false,
	    		  0,
	    		  3,
	    		  1,
	    		  "Puntuacion",
	    		  0,
	    		  null);
	      
	      if(Gui.DEBUG)System.out.println(gc.crearCompetencia(c).getMensaje());
	     
	}
	   
}