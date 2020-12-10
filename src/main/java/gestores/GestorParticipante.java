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
	
	public Mensaje crearParticipante(ParticipanteDTO pdto) {
		Mensaje mensaje = new Mensaje();
		if(pd.verificarExistenciaNombre(pdto.getNombre(), pdto.getIdCompetencia())) {
			mensaje.setAccion(1);
			mensaje.setTexto("Ya existe un participante con este nombre");
			return mensaje;
		}
		if(pd.verificarExistenciaMail(pdto.getIdCompetencia(),pdto.getEmail())) {
			mensaje.setAccion(2);
			mensaje.setTexto("Ya existe un participante con este email");
			return mensaje;
		}
		Competencia compe = gc.verificarCompetencia(pdto);
		if(compe==null) {
			mensaje.setAccion(3);
			mensaje.setTexto("Ya no se puede agregar participantes a esta competencia");
			return mensaje;
		}
		Participante p = new Participante(pdto.getNombre(), pdto.getEmail(), compe);
		gc.agregarParticipante(p, compe);
		mensaje.setAccion(0);
		mensaje.setTexto("La operación ha culminado con éxito");
		return mensaje;
	}
	
	public List<ParticipanteDTO> getParticipantes(int idCompetencia){
		List<ParticipanteDTO> participantes = new ArrayList<ParticipanteDTO>();
		this.cd.getParticipantes(idCompetencia).stream()
			.forEach(p -> participantes.add(new ParticipanteDTO(p.getNombre(), p.getEmail(), idCompetencia)));
		return participantes;
	}

}
