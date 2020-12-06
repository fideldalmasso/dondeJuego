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
import gui.Gui;

public class Prueba {
	
	public static void main(String[] args) {
	      
	      PaisDAO pd = new PaisDAO();
	      ProvinciaDAO prod = new ProvinciaDAO();
	      LocalidadDAO locd =  new LocalidadDAO();
	      UsuarioDAO ud =  new UsuarioDAO();
	      LugarRealizacionDAO ld =  new LugarRealizacionDAO();
	      GestorAutenticacion ga = new GestorAutenticacion();
	      GestorCompetencia gc = new GestorCompetencia();
	      
	      ga.login("dieguitomaradona@gmail.com", "12345");
	      /*
	      Pais pais = new Pais("Argentina", new ArrayList<Provincia>());
	      pd.save(pais);
	      Provincia prov =  new Provincia(pais, "Santa Fe", new ArrayList<Localidad>());
	      prod.save(prov);
	      Localidad loc = new Localidad(prov, "Santa Fe");
	      locd.save(loc);
	      
	      Deporte dep = gc.crearDeporte("Tenis de mesa 3");
	      Set<Deporte> deportes = new HashSet<Deporte>();
	      deportes.add(dep);
	      
	      LugarRealizacion lr = new LugarRealizacion("Nuevo Gasometro","Estadio temporal",null,deportes);
	      ld.save(lr);
	      
	      Pair p = new Pair(lr.getId(),1000);
	      List<Pair> lp = new ArrayList<Pair>();
	      lp.add(p);
	      
	      CompetenciaDTO c = new CompetenciaDTO(
	    		  "Copa Diego Armando Maradona",
	    		  dep.getId(),
	    		  lp,
	    		  "Liga",
	    		  "Vale todo",
	    		  false,
	    		  0,
	    		  3,
	    		  1,
	    		  "Puntuación",
	    		  0,
	    		  null);
	      
	      gc.crearCompetencia(c);
	      */
	      //Competencia compe = gc.getCompetencia(348);
	      
	      /*Participante p1 = new Participante();
	      p1.setEmail("damianlips@gmail.com");
	      p1.setNombre("Damian Lipschitz");
	      Participante p2 = new Participante();
	      p2.setEmail("fedenq@gmail.com");
	      p2.setNombre("Federico Quijada");
	      Participante p3 = new Participante();
	      p3.setEmail("fideldalmasso@gmail.com");
	      p3.setNombre("Fidel Dalmasso");
	      Participante p4 = new Participante();
	      p4.setEmail("juanpablocabana2@gmail.com");
	      p4.setNombre("Juan Cabana");
	      
	      gc.agregarParticipante(p1, compe);
	      gc.agregarParticipante(p2, compe);
	      gc.agregarParticipante(p3, compe);
	      gc.agregarParticipante(p4, compe);
	      */
	      
	      GestorFixture gf =  new GestorFixture();
	      gf.generarFixture(348);
	      gf.crearFixture();
	      
	     
	}
	   
}