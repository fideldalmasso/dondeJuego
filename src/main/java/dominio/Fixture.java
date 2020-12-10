package dominio;

import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.fixture")
public class Fixture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="fechaCreacion")
	private Timestamp fechaCreacion;
	@OneToMany(mappedBy="fixture", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Fecha> fechas;
	@OneToOne
	@JoinColumn(name = "idCompetencia")
	private Competencia competencia;
	
	public Fixture() {
		super();
		this.fechas = new HashSet<Fecha>();
	}
	public Fixture(Integer id, Timestamp fechaCreacion, Set<Fecha> fechas) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechas = fechas;
	}
	public Fixture(Timestamp fechaCreacion, Set<Fecha> fechas) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.fechas = fechas;
	}
	public Set<Fecha> getFechas() {
		return fechas;
	}
	public void setFechas(Set<Fecha> fechas) {
		this.fechas = fechas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void addFecha(Fecha fecha) {
		this.fechas.add(fecha);
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	
}
