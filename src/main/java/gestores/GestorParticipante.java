package gestores;

import java.util.ArrayList;
import java.util.List;

import daos.CompetenciaDAO;
import daos.ParticipanteDAO;
import dominio.*;
import dtos.ParticipanteDTO;

public class GestorParticipante {
	private ParticipanteDAO pd;
	private CompetenciaDAO cd;
	private GestorCompetencia gc;
	
	public GestorParticipante() {
		pd = new ParticipanteDAO();
		cd = new CompetenciaDAO();
		gc = new GestorCompetencia();
	}
	
	public void crearParticipante(ParticipanteDTO pdto) {
		if(pd.verificarExistencia(pdto.getNombre(), pdto.getIdCompetencia(), pdto.getEmail())) {
			//tirar excepcion o algo
		}
		Competencia compe = gc.verificarCompetencia(pdto);
		if(compe==null) {
			//tirar excepcion o algo
		}
		Participante p = new Participante(pdto.getNombre(), pdto.getEmail(), compe);
		gc.agregarParticipante(p, compe);
	}
	
	public List<ParticipanteDTO> getParticipantes(int idCompetencia){
		List<ParticipanteDTO> participantes = new ArrayList<ParticipanteDTO>();
		this.cd.getParticipantes(idCompetencia).stream()
			.forEach(p -> participantes.add(new ParticipanteDTO(p.getNombre(), p.getEmail(), idCompetencia)));
		return participantes;
	}

}
