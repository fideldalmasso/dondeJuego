package dominio;

import java.sql.Timestamp;
import java.util.Set;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.encuentroEliminatoriaDoble")
public class EncuentroEliminatoriaDoble extends Encuentro {
	@OneToOne
	@JoinColumn(name="destinoPerdedor")
	private EncuentroEliminatoriaDoble ganador;
	@OneToOne
	@JoinColumn(name="destinoGanador")
	private EncuentroEliminatoriaDoble perdedor;
	
	public EncuentroEliminatoriaDoble(Integer id, Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, Set<Resultado> resultados,
			EncuentroEliminatoriaDoble ganador, EncuentroEliminatoriaDoble perdedor) {
		super(id, fechaEncuentro, sePresentaB, sePresentaA, participanteA, participanteB, vigente, resultados);
		this.ganador = ganador;
		this.perdedor = perdedor;
	}
	public EncuentroEliminatoriaDoble(Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, Set<Resultado> resultados,
			EncuentroEliminatoriaDoble ganador, EncuentroEliminatoriaDoble perdedor) {
		super(fechaEncuentro, sePresentaB, sePresentaA, participanteA, participanteB, vigente, resultados);
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
	public EncuentroEliminatoriaDoble() {
		super();
	}
}
