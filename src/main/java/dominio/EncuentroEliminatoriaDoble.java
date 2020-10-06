package dominio;

import java.sql.Timestamp;
import java.util.List;

public class EncuentroEliminatoriaDoble extends Encuentro {
	private EncuentroEliminatoriaDoble ganador;
	private EncuentroEliminatoriaDoble perdedor;
	public EncuentroEliminatoriaDoble(Integer id, Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, List<Resultado> resultados,
			EncuentroEliminatoriaDoble ganador, EncuentroEliminatoriaDoble perdedor) {
		super(id, fechaEncuentro, sePresentaB, sePresentaA, participanteA, participanteB, vigente, resultados);
		this.ganador = ganador;
		this.perdedor = perdedor;
	}
	public EncuentroEliminatoriaDoble getGanador() {
		return ganador;
	}
	public void setGanador(EncuentroEliminatoriaDoble ganador) {
		this.ganador = ganador;
	}
	public EncuentroEliminatoriaDoble getPerdedor() {
		return perdedor;
	}
	public void setPerdedor(EncuentroEliminatoriaDoble perdedor) {
		this.perdedor = perdedor;
	}
	
}
