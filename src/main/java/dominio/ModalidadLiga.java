package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.modalidadLiga")
@PrimaryKeyJoinColumn(name = "idModalidad")
public class ModalidadLiga extends Modalidad {
	@Column(name="permiteEmpate")
	private Boolean permiteEmpate;
	@Column(name="puntosPorPresentarse")
	private Integer puntosPorPresentarse;
	@Column(name="puntosPorEmpate")
	private Integer puntosPorEmpate;
	@Column(name="puntosPorGanar")
	private Integer puntosPorGanar;
	public ModalidadLiga() {
		super();
	}
	public ModalidadLiga(Boolean permiteEmpate, Integer puntosPorPresentarse, Integer puntosPorEmpate, Integer puntosPorGanar) {
		super();
		this.permiteEmpate = permiteEmpate;
		this.puntosPorPresentarse = puntosPorPresentarse;
		this.puntosPorEmpate = puntosPorEmpate;
		this.puntosPorGanar = puntosPorGanar;
	}
	public Boolean getPermiteEmpate() {
		return permiteEmpate;
	}
	public void setPermiteEmpate(Boolean permiteEmpate) {
		this.permiteEmpate = permiteEmpate;
	}
	public Integer getPuntosPorPresentarse() {
		return puntosPorPresentarse;
	}
	public void setPuntosPorPresentarse(Integer puntosPorPresentarse) {
		this.puntosPorPresentarse = puntosPorPresentarse;
	}
	public Integer getPuntosPorEmpate() {
		return puntosPorEmpate;
	}
	public void setPuntosPorEmpate(Integer puntosPorEmpate) {
		this.puntosPorEmpate = puntosPorEmpate;
	}
	public Integer getPuntosPorGanar() {
		return puntosPorGanar;
	}
	public void setPuntosPorGanar(Integer puntosPorGanar) {
		this.puntosPorGanar = puntosPorGanar;
	}
	
}
