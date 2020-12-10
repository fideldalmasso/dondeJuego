package dominio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enumerados.EstadoCompetencia;

@Entity
@Table(name="dj.competencia")
public class Competencia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Enumerated(EnumType.STRING)
	private EstadoCompetencia estado;
	@Column(name="reglamento")
	private String reglamento;
	@Column(name="fechaInicio")
	private Timestamp fechaInicio;
	@Column(name="fechaFin")
	private Timestamp fechaFin;
	@Column(name="fechaHoraBajaLogica")
	private Timestamp fechaHoraBajaLogica;
	@ManyToOne
	@JoinColumn(name="idDeporte")
	private Deporte deporte;
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="idSistemaPuntuacion")
	private SistemaPuntuacion sistemaPuntuacion;
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="idModalidad")
	private Modalidad modalidad;
	@OneToMany(mappedBy="competencia", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<CompetenciaLugar> lugares;
	@OneToMany(mappedBy="competencia", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Participante> participantes;
	@OneToOne(mappedBy = "competencia", fetch=FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval=true)
	private Fixture fixture;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public Competencia(Integer id, String nombre, EstadoCompetencia estado, String reglamento, Timestamp fechaInicio,
			Timestamp fechaFin, Timestamp fechaHoraBajaLogica, Deporte deporte, SistemaPuntuacion sistemaPuntuacion,
			Modalidad modalidad, Set<CompetenciaLugar> lugares, Set<Participante> participantes, Fixture fixture, Usuario usr) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.reglamento = reglamento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaHoraBajaLogica = fechaHoraBajaLogica;
		this.deporte = deporte;
		this.sistemaPuntuacion = sistemaPuntuacion;
		this.modalidad = modalidad;
		this.lugares = lugares;
		this.participantes = participantes;
		this.fixture = fixture;
	}
	public Competencia(String nombre, EstadoCompetencia estado, String reglamento, Timestamp fechaInicio,
			Timestamp fechaFin, Timestamp fechaHoraBajaLogica, Deporte deporte, SistemaPuntuacion sistemaPuntuacion,
			Modalidad modalidad, Set<CompetenciaLugar> lugares, Set<Participante> participantes, Fixture fixture, Usuario usr) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.reglamento = reglamento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaHoraBajaLogica = fechaHoraBajaLogica;
		this.deporte = deporte;
		this.sistemaPuntuacion = sistemaPuntuacion;
		this.modalidad = modalidad;
		this.lugares = lugares;
		this.participantes = participantes;
		this.fixture = fixture;
	}
	public Competencia() {
		super();
		this.lugares = new HashSet<CompetenciaLugar>();
		this.participantes = new HashSet<Participante>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public EstadoCompetencia getEstado() {
		return estado;
	}
	public void setEstado(EstadoCompetencia estado) {
		this.estado = estado;
	}
	public String getReglamento() {
		return reglamento;
	}
	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Timestamp getFechaHoraBajaLogica() {
		return fechaHoraBajaLogica;
	}
	public void setFechaHoraBajaLogica(Timestamp fechaHoraBajaLogica) {
		this.fechaHoraBajaLogica = fechaHoraBajaLogica;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	public SistemaPuntuacion getSistemaPuntuacion() {
		return sistemaPuntuacion;
	}
	public void setSistemaPuntuacion(SistemaPuntuacion sistemaPuntuacion) {
		this.sistemaPuntuacion = sistemaPuntuacion;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	public Set<CompetenciaLugar> getLugares() {
		return lugares;
	}
	public void setLugares(Set<CompetenciaLugar> lugares) {
		this.lugares = lugares;
	}
	public Set<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}
	public Fixture getFixture() {
		return fixture;
	}
	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
