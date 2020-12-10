package app;

import gestores.*;

import java.util.ArrayList;
import dominio.*;
import dtos.*;

public class CargarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  GestorAutenticacion ga = new GestorAutenticacion();
		  //ga.login("dieguitomaradona@gmail.com", "12345");
		
			GestorDeporte gd = new GestorDeporte();
			
			// acordarse de cambiar el id  de getlugar y de newpair, buscando uno  
			
			/*
			
			// ESTO AGREGA UNA COMPE CON 2 PARTICIPANTES, cambiar valor de lugar
			Deporte nuevodeporte = gd.crearDeporte("Futbol");
			GestorLugarRealizacion grl = new GestorLugarRealizacion();
			Integer lugar = 581;
			// acordarse de cambiar el id  de getlugar y de newpair, buscando uno  
			LugarRealizacion lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			ArrayList<Pair> lp = new ArrayList<Pair>();
			Pair np = new Pair(lugar, 3);
			lp.add(np);
			
			CompetenciaDTO cdto = new CompetenciaDTO("Competencia Uno", nuevodeporte.getId(), lp, "Liga", "la unica regla es que si hay reglas", true, 2, 3, 1, "Resultado Final", 1, 1);
			
			GestorCompetencia gc = new GestorCompetencia();
			Competencia compe = gc.crearCompetencia2(cdto);
			GestorParticipante gp = new GestorParticipante();
			
			ParticipanteDTO pdto = new ParticipanteDTO("Gervasio Gomez", "GGer@gmail.com", compe.getId());
			ParticipanteDTO pdto2 = new ParticipanteDTO("Mariano Mercado", "MMer@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			gp.crearParticipante(pdto2);
			*/
			
			/*
			 
			 
			 	// ESTO AGREGA UNA COMPE CON 4 PARTICIPANTES, cambiar valor de lugar
			 	
			Deporte nuevodeporte = gd.crearDeporte("Rugby");
			GestorLugarRealizacion grl = new GestorLugarRealizacion();
			Integer lugar = 581;
			
			LugarRealizacion lr = grl.getLugarRealizacion(lugar);
			lr.getDeportes().add(nuevodeporte);
			ArrayList<Pair> lp = new ArrayList<Pair>();
			Pair np = new Pair(lugar, 3);
			lp.add(np);
			
			CompetenciaDTO cdto = new CompetenciaDTO("Competencia Dos", nuevodeporte.getId(), lp, "Liga", "la unica regla es que no hay reglas", true, 2, 3, 1, "Resultado Final", 1, 1);
			
			GestorCompetencia gc = new GestorCompetencia();
			Competencia compe = gc.crearCompetencia2(cdto);
			GestorParticipante gp = new GestorParticipante();
			
			ParticipanteDTO pdto = new ParticipanteDTO("Martin Gomez", "mMgomezr@gmail.com", compe.getId());
			ParticipanteDTO pdto2 = new ParticipanteDTO("Pablo Lescano", "Pablito@gmail.com", compe.getId());
			ParticipanteDTO pdto3 = new ParticipanteDTO("Juan Pablo Pablito", "JPP@gmail.com", compe.getId());
			ParticipanteDTO pdto4 = new ParticipanteDTO("Juan Pablo Python", "juampy@gmail.com", compe.getId());
			gp.crearParticipante(pdto);
			gp.crearParticipante(pdto2);
			gp.crearParticipante(pdto3);
			gp.crearParticipante(pdto4);
			*/
			
			/*
			 
			 
			 //AGREGO NUEVA COMPE DE 3 PARTICIPANTES 
			  ga.login("ronaldinho@hotmail.com", "6789");
			  
			  Deporte nuevodeporte = gd.crearDeporte("Golf");
				GestorLugarRealizacion grl = new GestorLugarRealizacion();
				Integer lugar = 583;
				
				LugarRealizacion lr = grl.getLugarRealizacion(lugar);
				lr.getDeportes().add(nuevodeporte);
				ArrayList<Pair> lp = new ArrayList<Pair>();
				Pair np = new Pair(lugar, 3);
				lp.add(np);
				
				CompetenciaDTO cdto = new CompetenciaDTO("Competencia Tres", nuevodeporte.getId(), lp, "Liga", "la unicaes que no hay reglas", true, 2, 3, 1, "Resultado Final", 1, 1);
				
				GestorCompetencia gc = new GestorCompetencia();
				Competencia compe = gc.crearCompetencia2(cdto);
				GestorParticipante gp = new GestorParticipante();
				
				ParticipanteDTO pdto = new ParticipanteDTO("Juansinho", "JuanBr@gmail.com", compe.getId());
				ParticipanteDTO pdto2 = new ParticipanteDTO("Fidelsinho", "FideBr@gmail.com", compe.getId());
				ParticipanteDTO pdto3 = new ParticipanteDTO("Damiansinho", "DamiBR@gmail.com", compe.getId());
				gp.crearParticipante(pdto);
				gp.crearParticipante(pdto2);
				gp.crearParticipante(pdto3);
				*/
			
				/*
				ga.login("ronaldinho@hotmail.com", "6789");
				Deporte nuevodeporte = gd.crearDeporte("Basket");
				GestorLugarRealizacion grl = new GestorLugarRealizacion();
				Integer lugar = 583;
				
				LugarRealizacion lr = grl.getLugarRealizacion(lugar);
				lr.getDeportes().add(nuevodeporte);
				ArrayList<Pair> lp = new ArrayList<Pair>();
				Pair np = new Pair(lugar, 3);
				lp.add(np);
				lugar = 582;
				lr = grl.getLugarRealizacion(lugar);
				np = new Pair(lugar, 5);
				lugar = 584;
				lr = grl.getLugarRealizacion(lugar);
				np = new Pair(lugar, 6);
				
				CompetenciaDTO cdto = new CompetenciaDTO("Competencia Cuatro", nuevodeporte.getId(), lp, "Liga", "esta es la competencia de muchos", true, 1, 5, 1, "Resultado Final", 1, 1);
				
				GestorCompetencia gc = new GestorCompetencia();
				Competencia compe = gc.crearCompetencia2(cdto);
				GestorParticipante gp = new GestorParticipante();
				
				ParticipanteDTO pdto = new ParticipanteDTO("Gervo Volador", "GVO@gmail.com", compe.getId());
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
				*/
				
				/*
					
				
				// agrego competencias invalidas 
				ga.login("ronaldinho@hotmail.com", "6789");
				Deporte nuevodeporte = gd.crearDeporte("Tenis");
				GestorLugarRealizacion grl = new GestorLugarRealizacion();
				Integer lugar = 581;
				
				LugarRealizacion lr = grl.getLugarRealizacion(lugar);
				lr.getDeportes().add(nuevodeporte);
				ArrayList<Pair> lp = new ArrayList<Pair>();
				Pair np = new Pair(lugar, 3);
				lp.add(np);
				lugar = 582;
				lr = grl.getLugarRealizacion(lugar);
				np = new Pair(lugar, 5);
				lugar = 584;
				lr = grl.getLugarRealizacion(lugar);
				np = new Pair(lugar, 6);
				
				CompetenciaDTO cdto = new CompetenciaDTO("Competencia Cinco", nuevodeporte.getId(), lp, "Eliminatoria doble", "esta es la prohibida muchachos", false, 3, 6, 3, "Resultado Final", 1, 1);
				
				GestorCompetencia gc = new GestorCompetencia();
				Competencia compe = gc.crearCompetencia2(cdto);
				GestorParticipante gp = new GestorParticipante();
				
				ParticipanteDTO pdto = new ParticipanteDTO("Fernando Quintana", "FQuintana@gmail.com", compe.getId());
				gp.crearParticipante(pdto);
				pdto = new ParticipanteDTO("Facundo Quiroga", "FQuiroga@gmail.com", compe.getId());
				gp.crearParticipante(pdto);
				
				cdto = new CompetenciaDTO("Competencia Seis", nuevodeporte.getId(), lp, "Eliminatoria simple", "esta es la otra prohibida", false, 4, 6, 4, "Sets", 1, 3);
				compe = gc.crearCompetencia2(cdto);
				
				pdto = new ParticipanteDTO("Juan Quintana", "JuanQuintana@gmail.com", compe.getId());
				gp.crearParticipante(pdto);
				pdto = new ParticipanteDTO("Fidel Quiroga", "FideQuiroga@gmail.com", compe.getId());
				gp.crearParticipante(pdto);
				
				*/
	}

}
