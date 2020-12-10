package app;

import gestores.*;

import java.util.ArrayList;
import java.util.HashSet;

import daos.LocalidadDAO;
import daos.LugarRealizacionDAO;
import daos.PaisDAO;
import daos.ProvinciaDAO;
import daos.UsuarioDAO;
import dominio.*;
import dtos.*;
import enumerados.TipoDocumento;

public class CargarDatosRonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  PaisDAO pd = new PaisDAO();
	      ProvinciaDAO prod = new ProvinciaDAO();
	      LocalidadDAO locd =  new LocalidadDAO();
	      UsuarioDAO ud =  new UsuarioDAO();
	      LugarRealizacionDAO ld =  new LugarRealizacionDAO();
	      GestorAutenticacion ga = new GestorAutenticacion();
	      GestorCompetencia gc = new GestorCompetencia();
	      GestorUsuario gu = new GestorUsuario();
	      
	      Pais pais = new Pais("Brasil", new ArrayList<Provincia>());
	      pd.save(pais);
	      Provincia prov =  new Provincia(pais, "Brasilia", new ArrayList<Localidad>());
	      prod.save(prov);
	      Localidad loc = new Localidad(prov, "Canarinha");
	      locd.save(loc);
	      
	      Usuario usr2 = new Usuario("Ronaldinho", "Asis", "6789", TipoDocumento.DNI, "43321332", "ronaldinho@hotmail.com",new HashSet<Competencia>(),
	  			new HashSet<RegistroSesion>(), new HashSet<LugarRealizacion>(), loc);   
	      Usuario theusr2 = gu.save(usr2);
	      
	      LugarRealizacion lr = new LugarRealizacion("El Bosque", "Estadio de Gimnasia", theusr2, new HashSet<Deporte>());
	      Integer a = ld.save(lr);
	      lr = new LugarRealizacion("Cementerio de Elefantes", "Estadio de Colon", theusr2, new HashSet<Deporte>());
	      Integer b = ld.save(lr);
	      lr = new LugarRealizacion("El Monumental", "Estadio River", theusr2, new HashSet<Deporte>());
	      Integer c = ld.save(lr);
	      
		//Compe de 3 participantes
		
		
			ga.login("ronaldinho@hotmail.com", "6789");
			 GestorDeporte gd = new GestorDeporte();
		  	Deporte nuevodeporte = gd.crearDeporte("Golf");
			GestorLugarRealizacion grl = new GestorLugarRealizacion();
			Integer lugar = a; // cambiar
			
			lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			ArrayList<Pair> lp = new ArrayList<Pair>();
			Pair np = new Pair(lugar, 3);
			lp.add(np);
			
			CompetenciaDTO cdto = new CompetenciaDTO("Competencia Tres", nuevodeporte.getId(), lp, "Liga", "la unicaes que no hay reglas", true, 2, 3, 1, "Resultado Final", 1, 1);
			
			gc = new GestorCompetencia();
			Competencia compe = gc.crearCompetencia2(cdto);
			GestorParticipante gp = new GestorParticipante();
			
			ParticipanteDTO pdto = new ParticipanteDTO("Juansinho", "JuanBr@gmail.com", compe.getId());
			ParticipanteDTO pdto2 = new ParticipanteDTO("Fidelsinho", "FideBr@gmail.com", compe.getId());
			ParticipanteDTO pdto3 = new ParticipanteDTO("Damiansinho", "DamiBR@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			gp.crearParticipante(pdto2);
			gp.crearParticipante(pdto3);
			
		
			nuevodeporte = gd.crearDeporte("Basket");
			grl = new GestorLugarRealizacion();
			lugar = b; // cambiar
			
			lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			lp = new ArrayList<Pair>();
			np = new Pair(lugar, 3);
			lp.add(np);
			lugar = a;
			lr = grl.getLugarRealizacion(lugar);
			np = new Pair(lugar, 5);
			lugar = c;
			lr = grl.getLugarRealizacion(lugar);
			np = new Pair(lugar, 6);
			
			cdto = new CompetenciaDTO("Competencia Cuatro", nuevodeporte.getId(), lp, "Liga", "esta es la competencia de muchos", true, 1, 5, 1, "Resultado Final", 1, 1);
			
			gc = new GestorCompetencia();
			compe = gc.crearCompetencia2(cdto);
			gp = new GestorParticipante();
			
			pdto = new ParticipanteDTO("Gervo Volador", "GVO@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Gervo Sapo", "GSA@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Gervo Tornado", "GTO@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Juan Nokab", "nokabjuan@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Juan Abania", "Juanabania@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Juan Cabani", "JJJC@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Juan Caaabni", "JACA@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			
			
			// agrego competencias invalidas 
			nuevodeporte = gd.crearDeporte("Tenis");
			grl = new GestorLugarRealizacion();
			lugar = a; // cambiar
			
			lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			lp = new ArrayList<Pair>();
			np = new Pair(lugar, 3);
			lp.add(np);
			lugar = b;
			lr = grl.getLugarRealizacion(lugar);
			np = new Pair(lugar, 5);
			lugar = c;
			lr = grl.getLugarRealizacion(lugar);
			np = new Pair(lugar, 6);
			
			cdto = new CompetenciaDTO("Competencia Cinco", nuevodeporte.getId(), lp, "Eliminatoria doble", "esta es la prohibida muchachos", false, 3, 6, 3, "Resultado Final", 1, 1);
			
			gc = new GestorCompetencia();
			compe = gc.crearCompetencia2(cdto);
			gp = new GestorParticipante();
			
			pdto = new ParticipanteDTO("Fernando Quintana", "FQuintana@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Facundo Quiroga", "FQuiroga@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			
			cdto = new CompetenciaDTO("Competencia Seis", nuevodeporte.getId(), lp, "Eliminatoria simple", "esta es la otra prohibida", false, 4, 6, 4, "Sets", 1, 3);
			compe = gc.crearCompetencia2(cdto);
			
			pdto = new ParticipanteDTO("Juan Quintana", "JuanQuintana@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			pdto = new ParticipanteDTO("Fidel Quiroga", "FideQuiroga@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			
			
	}

}
