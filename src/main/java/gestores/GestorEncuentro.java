package gestores;

import daos.*;
import dominio.*;
import dtos.*;

public class GestorEncuentro {
	private EncuentroDAO ed;
	private GestorCompetencia gc;
	private GestorResultado gr;
	
	public GestorEncuentro() {
		ed= new EncuentroDAO();
		gc = new GestorCompetencia();
		gr = new GestorResultado();
	}
	
	public EncuentroDTO getEncuentro(Integer idEncuentro) {
		Encuentro encuentro = ed.getEncuentro(idEncuentro);
		if((encuentro instanceof EncuentroEliminatoriaSimple && ((EncuentroEliminatoriaSimple)encuentro).getGanador().getVigente()!=null )
				||
				(encuentro instanceof EncuentroEliminatoriaDoble && 
						(((EncuentroEliminatoriaDoble)encuentro).getGanador().getVigente()!=null 
						|| 
						((EncuentroEliminatoriaDoble)encuentro).getPerdedor().getVigente()!=null 
						)
				)
		) {
			return null;
		}
		else {
			EncuentroDTO edto;
			Resultado r= encuentro.getVigente();
			if(r==null)
			edto = new EncuentroDTO(encuentro.getId(),encuentro.getParticipanteA().getNombre(), encuentro.getParticipanteB().getNombre(), null);
			else {
				ResultadoDTO rdto=null;
				if(r instanceof ResultadoFinal) {
					rdto = new ResultadoFinalDTO(r.getId(),((ResultadoFinal) r).getEmpate(),((ResultadoFinal) r).getGanaA(),((ResultadoFinal) r).getGanaB());
				}
				if(r instanceof ResultadoPuntuacion) {
					rdto = new ResultadoPuntuacionDTO(((ResultadoPuntuacion) r).getPuntajeFinalA(), ((ResultadoPuntuacion) r).getPuntajeFinalB(), r.getId());
				}
				if(r instanceof ResultadoSets) {
					rdto = new ResultadoSetsDTO(r.getId(), ((ResultadoSets) r).getSets());
				}
				edto = new EncuentroDTO(encuentro.getId(),encuentro.getParticipanteA().getNombre(), encuentro.getParticipanteB().getNombre(), rdto);
			}
			return edto;
		}
	}
	
	public Mensaje asignarResultado(ResultadoFinalDTO rdto, Integer idEncuentro) {
		if(idEncuentro == null || rdto.getEmpate()==null || rdto.getGanaA()==null || rdto.getGanaB()==null) {
			//Manejo de mensajes
		}
		else {
			Integer cont = 0;
			if(rdto.getEmpate()) cont++;
			if(rdto.getGanaA()) cont++;
			if(rdto.getGanaB()) cont++;
			if(cont==0) {
				//Manejo de mensajes
			}
			else if (cont>1) {
				//Manejo de mensajes
			}
			else {
				Encuentro encuentro = ed.getEncuentro(idEncuentro);
				ResultadoFinal rf= gr.crearResultado(rdto);
				rf.setEncuentro(encuentro);
				Resultado vigente = encuentro.getVigente();
				if(vigente!=null) {
					encuentro.getResultados().add(vigente);
				}
				encuentro.setVigente(rf);
				gc.actualizarFixture(encuentro.getFecha().getFixture().getCompetencia());
				//Manejo de mensajes
			}			
		}

		return null;
	}
	
	public Mensaje asignarResultado(ResultadoPuntuacionDTO rdto, Integer idEncuentro) {
		if(idEncuentro == null || rdto.getPuntajeFinalA()==null || rdto.getPuntajeFinalB()==null) {
			//Manejo de mensajes
		}
		else {
			if( rdto.getPuntajeFinalA() < 0) {
				//Manejo de mensajes
			}
			else if (rdto.getPuntajeFinalB() < 0) {
				//Manejo de mensajes
			}
			//Mas comprobaciones?
			else {
				Encuentro encuentro = ed.getEncuentro(idEncuentro);
				ResultadoPuntuacion rp = gr.crearResulado(rdto);
				rp.setEncuentro(encuentro);
				Resultado vigente = encuentro.getVigente();
				if(vigente!=null) {
					encuentro.getResultados().add(vigente);
				}
				encuentro.setVigente(rp);
				gc.actualizarFixture(encuentro.getFecha().getFixture().getCompetencia());
				//Manejo de mensajes
			}			
		}

		return null;
	}
	
	public Mensaje asignarResultado(ResultadoSetsDTO rdto, Integer idEncuentro) {
		if(idEncuentro == null || rdto.getSets()==null) {
			//Manejo de mensajes
		}
		else {
			//Mas comprobaciones?
				Encuentro encuentro = ed.getEncuentro(idEncuentro);
				ResultadoSets rs = gr.crearResultado(rdto);
				rs.setEncuentro(encuentro);
				Resultado vigente = encuentro.getVigente();
				if(vigente!=null) {
					encuentro.getResultados().add(vigente);
				}
				encuentro.setVigente(rs);
				gc.actualizarFixture(encuentro.getFecha().getFixture().getCompetencia());
				//Manejo de mensajes
						
		}

		return null;
	}
	
	
}
