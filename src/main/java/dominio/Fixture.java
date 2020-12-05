package dominio;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@OneToMany(mappedBy="fixture")
	private List<Fecha> fechas;
	@OneToOne
	@JoinColumn(name = "idCompetencia")
	private Competencia competencia;
	
	public Fixture() {
		super();
	}
	public Fixture(Integer id, Timestamp fechaCreacion, List<Fecha> fechas) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechas = fechas;
	}
	public Fixture(Timestamp fechaCreacion, List<Fecha> fechas) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.fechas = fechas;
	}
	public List<Fecha> getFechas() {
		return fechas;
	}
	public void setFechas(List<Fecha> fechas) {
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
