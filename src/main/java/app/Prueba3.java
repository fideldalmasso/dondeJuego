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
import dominio.Participante;
import dominio.Provincia;
import dominio.RegistroSesion;
import dominio.Usuario;
import dtos.CompetenciaDTO;
import enumerados.TipoDocumento;
import gestores.GestorAutenticacion;
import gestores.GestorCompetencia;
import gestores.GestorFixture;
import gestores.GestorLugarRealizacion;
import gestores.GestorUsuario;
import gui.Gui;

public class Prueba3{
	
	public static void main(String[] args) {
	      
	      PaisDAO pd = new PaisDAO();
	      ProvinciaDAO prod = new ProvinciaDAO();
	      LocalidadDAO locd =  new LocalidadDAO();
	      UsuarioDAO ud =  new UsuarioDAO();
	      LugarRealizacionDAO ld =  new LugarRealizacionDAO();
	      GestorAutenticacion ga = new GestorAutenticacion();
	      GestorCompetencia gc = new GestorCompetencia();
	      GestorUsuario gu = new GestorUsuario();
	      /*
	      
	      // ESTO AGREGA DOS PAISES Y UN USUARIO NUEVO, MAS 5 LUGARESREALIZACION
	       
	      Pais pais = new Pais("Argentina", new ArrayList<Provincia>());
	      pd.save(pais);
	      Provincia prov =  new Provincia(pais, "Santa Fe", new ArrayList<Localidad>());
	      prod.save(prov);
	      Localidad loc = new Localidad(prov, "Santafecito");
	      locd.save(loc);
	      loc = new Localidad(prov, "Venado Tuerto");
	      locd.save(loc);
	      prov = new Provincia(pais, "Salta", new ArrayList<Localidad>());
	      prod.save(prov);
	      loc = new Localidad(prov, "Monte Alto");
	      locd.save(loc);
	      loc = new Localidad(prov, "Sanadores");
	      locd.save(loc);
	      
	      Usuario usr = new Usuario("Diego", "Maradona", "12345",
	    		  TipoDocumento.DNI, "42241045", "dieguitomaradona@gmail.com", new HashSet<Competencia>(),
			new HashSet<RegistroSesion>(), new HashSet<LugarRealizacion>(), loc);
	      Usuario tohaveidusr = gu.save(usr);
	      ga.login("dieguitomaradona@gmail.com", "12345");
	      
	      pais = new Pais("Bolivia", new ArrayList<Provincia>());
	      pd.save(pais);
	      prov =  new Provincia(pais, "Sucre", new ArrayList<Localidad>());
	      prod.save(prov);
	      loc = new Localidad(prov, "Anasia");
	      locd.save(loc);
	      loc = new Localidad(prov, "Andase");
	      locd.save(loc);
	      prov = new Provincia(pais, "La Paz", new ArrayList<Localidad>());
	      prod.save(prov);
	      loc = new Localidad(prov, "La Santa");
	      locd.save(loc);
	      loc = new Localidad(prov, "Lospes");
	      locd.save(loc);
	      
	      
	      LugarRealizacion lr = new LugarRealizacion("Nuevo Gasometro","Estadio temporal", tohaveidusr.getId() ,new HashSet<Deporte>());
	      ld.save(lr);
	      lr = new LugarRealizacion("La Bombonera", "Estadio Boca", tohaveidusr.getId(), new HashSet<Deporte>());
	      ld.save(lr);
	      lr = new LugarRealizacion("El Monumental", "Estadio River", tohaveidusr.getId(), new HashSet<Deporte>());
	      ld.save(lr);
	     
	      */
	      
	      /*
	      
	      // ESTO AGREGA UN NUEVO USUARIO + BRASIL
	      Pais pais = new Pais("Brasil", new ArrayList<Provincia>());
	      pd.save(pais);
	      Provincia prov =  new Provincia(pais, "Brasilia", new ArrayList<Localidad>());
	      prod.save(prov);
	      Localidad loc = new Localidad(prov, "Canarinha");
	      locd.save(loc);
	      
	      Usuario usr2 = new Usuario("Ronaldinho", "Asis", "6789", TipoDocumento.DNI, "43321332", "ronaldinho@hotmail.com",new HashSet<Competencia>(),
	  			new HashSet<RegistroSesion>(), new HashSet<LugarRealizacion>(), loc);   
	      Usuario tohaveidusr2 = gu.save(usr2);
	      
	      LugarRealizacion lr = new LugarRealizacion("El Bosque", "Estadio de Gimnasia", tohaveidusr2.getId(), new HashSet<Deporte>());
	      ld.save(lr);
	      lr = new LugarRealizacion("Cementerio de Elefantes", "Estadio de Colon", tohaveidusr2.getId(), new HashSet<Deporte>());
	      ld.save(lr);
	      
	      */
	      // anda bien esto tb
	      
	      
	      
	    //  Pair p = new Pair(lr.getId(),1000);
	    // List<Pair> lp = new ArrayList<Pair>();
	    //  lp.add(p);
	      
	}
	   
}