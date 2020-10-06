package dominio;

import java.sql.Timestamp;
import java.util.List;

public class Encuentro {
	protected Integer id;
	protected Timestamp fechaEncuentro;
	protected Boolean sePresentaB;
	protected Boolean sePresentaA;
	protected Participante participanteA;
	protected Participante participanteB;
	protected Resultado vigente;
	protected List<Resultado> resultados;
	public Encuentro(Integer id, Timestamp fechaEncuentro, Boolean sePresentaB, Boolean sePresentaA,
			Participante participanteA, Participante participanteB, Resultado vigente, List<Resultado> resultados) {
		super();
		this.id = id;
		this.fechaEncuentro = fechaEncuentro;
		this.sePresentaB = sePresentaB;
		this.sePresentaA = sePresentaA;
		this.participanteA = participanteA;
		this.participanteB = participanteB;
		this.vigente = vigente;
		this.resultados = resultados;
	}
	public Encuentro() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getFechaEncuentro() {
		return fechaEncuentro;
	}
	public void setFechaEncuentro(Timestamp fechaEncuentro) {
		this.fechaEncuentro = fechaEncuentro;
	}
	public Boolean getSePresentaB() {
		return sePresentaB;
	}
	public void setSePresentaB(Boolean sePresentaB) {
		this.sePresentaB = sePresentaB;
	}
	public Boolean getSePresentaA() {
		return sePresentaA;
	}
	public void setSePresentaA(Boolean sePresentaA) {
		this.sePresentaA = sePresentaA;
	}
	public Participante getParticipanteA() {
		return participanteA;
	}
	public void setParticipanteA(Participante participanteA) {
		this.participanteA = participanteA;
	}
	public Participante getParticipanteB() {
		return participanteB;
	}
	public void setParticipanteB(Participante participanteB) {
		this.participanteB = participanteB;
	}
	public Resultado getVigente() {
		return vigente;
	}
	public void setVigente(Resultado vigente) {
		this.vigente = vigente;
	}
	public List<Resultado> getResultados() {
		return resultados;
	}
	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
	
}
