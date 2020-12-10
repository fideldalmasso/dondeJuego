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
import dtos.ParticipanteDTO;
import enumerados.TipoDocumento;
import gestores.GestorAutenticacion;
import gestores.GestorCompetencia;
import gestores.GestorDeporte;
import gestores.GestorFixture;
import gestores.GestorLugarRealizacion;
import gestores.GestorParticipante;
import gestores.GestorUsuario;
import gui.Gui;

public class Prueba3{
	
	public static void main(String[] args) {
	      
	      PaisDAO pd = new PaisDAO();
	      ProvinciaDAO prod = new ProvinciaDAO();
	      LocalidadDAO locd =  new LocalidadDAO();
	      LugarRealizacionDAO ld =  new LugarRealizacionDAO();
	      GestorAutenticacion ga = new GestorAutenticacion();
	      GestorCompetencia gc = new GestorCompetencia();
	      GestorUsuario gu = new GestorUsuario();
	      
	      
	      // ESTO AGREGA DOS PAISES Y UN USUARIO NUEVO, MAS 5 LUGARESREALIZACION
	       
	      Pais pais = new Pais("Argentina", new ArrayList<Provincia>());
	      pd.save(pais);
	      Provincia prov =  new Provincia(pais, "Santa Fe", new ArrayList<Localidad>());
	      prod.save(prov);
	      Localidad loc = new Localidad(prov, "Santafecito");
	      locd.save(loc);
	     /* loc = new Localidad(prov, "Venado Tuerto");
	      locd.save(loc);
	      prov = new Provincia(pais, "Salta", new ArrayList<Localidad>());
	      prod.save(prov);
	      loc = new Localidad(prov, "Monte Alto");
	      locd.save(loc);
	      loc = new Localidad(prov, "Sanadores");
	      locd.save(loc);*/
	      
	      Usuario usr = new Usuario("Diego", "Maradona", "12345",
	    		  TipoDocumento.DNI, "42241045", "dieguitomaradona@gmail.com", new HashSet<Competencia>(),
			new HashSet<RegistroSesion>(), new HashSet<LugarRealizacion>(), loc);
	      Usuario theusr = gu.save(usr);
	    // ga.login("dieguitomaradona@gmail.com", "12345");
	      
	    /*  pais = new Pais("Bolivia", new ArrayList<Provincia>());
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
	      locd.save(loc);*/
	      
	      
	      LugarRealizacion lr = new LugarRealizacion("Nuevo Gasometro","Estadio temporal", theusr ,new HashSet<Deporte>());
	      Integer a = ld.save(lr);
	      lr = new LugarRealizacion("La Bombonera", "Estadio Boca", theusr, new HashSet<Deporte>());
	      Integer b = ld.save(lr);
	      
	      ga.login("dieguitomaradona@gmail.com", "12345");
			
		  GestorDeporte gd = new GestorDeporte();
			
			// acordarse de cambiar el id  de getlugar y de newpair, buscando uno  

			
			// ESTO AGREGA UNA COMPE CON 2 PARTICIPANTES, cambiar valor de lugar
			
			Deporte nuevodeporte = gd.crearDeporte("Futbol");
			GestorLugarRealizacion grl = new GestorLugarRealizacion();
			Integer lugar = a; // cambiar
			
			lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			ld.update(lr);
			ArrayList<Pair> lp = new ArrayList<Pair>();
			Pair np = new Pair(lugar, 3);
			lp.add(np);
			
			CompetenciaDTO cdto = new CompetenciaDTO("Competencia Uno", nuevodeporte.getId(), lp, "Liga", "la unica regla es que si hay reglas", true, 2, 3, 1, "Resultado Final", 1, 1);
			
			gc = new GestorCompetencia();
			Competencia compe = gc.crearCompetencia2(cdto);
			GestorParticipante gp = new GestorParticipante();
			
			ParticipanteDTO pdto = new ParticipanteDTO("Gervasio Gomez", "GGer@gmail.com", compe.getId());
			ParticipanteDTO pdto2 = new ParticipanteDTO("Mariano Mercado", "MMer@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			gp.crearParticipante(pdto2);
		
			// ESTO AGREGA UNA COMPE CON 4 PARTICIPANTES, cambiar valor de lugar
			/* 	
			nuevodeporte = gd.crearDeporte("Rugby");
			grl = new GestorLugarRealizacion();
			lugar = b;
			
			lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			ld.update(lr);
			lp = new ArrayList<Pair>();
			np = new Pair(lugar, 3);
			lp.add(np);
			
			cdto = new CompetenciaDTO("Competencia Dos", nuevodeporte.getId(), lp, "Liga", "la unica regla es que no hay reglas", true, 2, 3, 1, "Resultado Final", 1, 1);
			
			gc = new GestorCompetencia();
			compe = gc.crearCompetencia2(cdto);
			gp = new GestorParticipante();
			
			pdto = new ParticipanteDTO("Martin Gomez", "mMgomezr@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Pablo Lescano", "Pablito@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Juan Pablo Pablito", "JPP@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Juan Pablo Python", "juampy@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
	     	*/
	}
	   
}