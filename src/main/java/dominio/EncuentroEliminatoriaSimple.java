package dominio;

import java.sql.Timestamp;
import java.util.List;

public class EncuentroEliminatoriaSimple extends Encuentro {
	private EncuentroEliminatoriaSimple ganador;

	public EncuentroEliminatoriaSimple(Integer id, Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, List<Resultado> resultados,
			EncuentroEliminatoriaSimple ganador) {
		super(id, fechaEncuentro, sePresentaB, sePresentaA, participanteA, participanteB, vigente, resultados);
		this.ganador = ganador;
	}

	public EncuentroEliminatoriaSimple getGanador() {
		return ganador;
	}

	public void setGanador(EncuentroEliminatoriaSimple ganador) {
		this.ganador = ganador;
	}
	public EncuentroEliminatoriaSimple() {
		super();
	}
}
