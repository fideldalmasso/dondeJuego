package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.competenciaLugar")
public class CompetenciaLugar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idCompetencia")
	private Competencia competencia;
	@ManyToOne
	@JoinColumn(name="idLugar")
	private LugarRealizacion lugar;
	@Column(name="disponibilidad")
	private Integer disponibilidad;
	
	public CompetenciaLugar(Integer id,Competencia competencia, LugarRealizacion lugar, Integer disponibilidad) {
		super();
		this.id=id;
		this.competencia = competencia;
		this.lugar = lugar;
		this.disponibilidad = disponibilidad;
	}
	public CompetenciaLugar(Competencia competencia, LugarRealizacion lugar, Integer disponibilidad) {
		super();
		this.id=id;
		this.competencia = competencia;
		this.lugar = lugar;
		this.disponibilidad = disponibilidad;
	}
	public CompetenciaLugar() {
		super();
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public LugarRealizacion getLugar() {
		return lugar;
	}
	public void setLugar(LugarRealizacion lugar) {
		this.lugar = lugar;
	}
	public Integer getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
