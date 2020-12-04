package gestores;

import daos.ParticipanteDAO;
import dominio.*;
import dtos.ParticipanteDTO;

public class GestorParticipante {
	private ParticipanteDAO pd;
	private GestorCompetencia gc;
	
	public GestorParticipante() {
		pd = new ParticipanteDAO();
		gc = new GestorCompetencia();
	}
	
	void crearParticipante(ParticipanteDTO pdto) {
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

}
