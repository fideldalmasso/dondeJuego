package dominio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import enumerados.EstadoCompetencia;

public class Competencia {
	private Integer id;
	private String nombre;
	private EstadoCompetencia estado;
	private String reglamento;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private Timestamp fechaHoraBajaLogica;
	private Deporte deporte;
	private SistemaPuntuacion sistemaPuntuacion;
	private Modalidad modalidad;
	private List<CompetenciaLugar> lugares;
	private List<Participante> participantes;
	private Fixture fixture;
	public Competencia(Integer id, String nombre, EstadoCompetencia estado, String reglamento, Timestamp fechaInicio,
			Timestamp fechaFin, Timestamp fechaHoraBajaLogica, Deporte deporte, SistemaPuntuacion sistemaPuntuacion,
			Modalidad modalidad, List<CompetenciaLugar> lugares, List<Participante> participantes, Fixture fixture) {
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
	public Competencia() {
		super();
		this.lugares = new ArrayList<CompetenciaLugar>();
		this.participantes = new ArrayList<Participante>();
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
	public List<CompetenciaLugar> getLugares() {
		return lugares;
	}
	public void setLugares(List<CompetenciaLugar> lugares) {
		this.lugares = lugares;
	}
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
	public Fixture getFixture() {
		return fixture;
	}
	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	
}
