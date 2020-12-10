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
	}

}
