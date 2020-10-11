package dominio;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="dj.encuentro")
public class Encuentro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column(name="fechaEncuentro")
	protected Timestamp fechaEncuentro;
	@Column(name="sePresentaB")
	protected Boolean sePresentaB;
	@Column(name="sePresentaA")
	protected Boolean sePresentaA;
	@ManyToOne
	@JoinColumn(name="ideParticipanteA")
	protected Participante participanteA;
	@ManyToOne
	@JoinColumn(name="ideParticipanteB")
	protected Participante participanteB;
	@OneToOne
	@JoinColumn(name="idEncuentro")
	protected Resultado vigente;
	@OneToMany
	@JoinColumn(name="idEncuentro")
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
