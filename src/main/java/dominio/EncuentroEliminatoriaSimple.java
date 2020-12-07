package dominio;

import java.sql.Timestamp;
import java.util.Set;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.encuentroEliminatoriaSimple")
public class EncuentroEliminatoriaSimple extends Encuentro {
	@OneToOne
	@JoinColumn(name="destinoGanador")
	private EncuentroEliminatoriaSimple ganador;

	public EncuentroEliminatoriaSimple(Integer id, Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, Set<Resultado> resultados,
			EncuentroEliminatoriaSimple ganador) {
		super(id, fechaEncuentro, sePresentaB, sePresentaA, participanteA, participanteB, vigente, resultados);
		this.ganador = ganador;
	}
	public EncuentroEliminatoriaSimple(Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, Set<Resultado> resultados,
			EncuentroEliminatoriaSimple ganador) {
		super(fechaEncuentro, sePresentaB, sePresentaA, participanteA, participanteB, vigente, resultados);
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
