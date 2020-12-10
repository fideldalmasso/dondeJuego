package dtos;

import java.util.List;

import dominio.Pair;

public class CompetenciaDTO {
	String nombre;
	Integer deporte;
	List<Pair> lugares;
	String modalidad;
	String sistemaPuntuacion;
	String reglamento;
	Boolean permiteEmpate;
	Integer puntosPorPresentarse;
	Integer puntosPorGanar;
	Integer puntosPorEmpate;
	Integer puntosPorAbandono;
	Integer cantidadMaximaSets;
	public CompetenciaDTO() {
		super();
	}
	public CompetenciaDTO(String nombre,
			Integer deporte,
			List<Pair> lugares,
			String modalidad,
			String reglamento,
			Boolean permiteEmpate,
			Integer puntosPorPresentarse,
			Integer puntosPorGanar,
			Integer puntosPorEmpate,
			String sistemaPuntuacion,
			Integer puntosPorAbandono,
			Integer cantidadMaximaSets) {
		super();
		this.nombre = nombre.toUpperCase();
		this.deporte = deporte;
		this.lugares = lugares;
		this.modalidad = modalidad;
		this.reglamento = reglamento;
		this.permiteEmpate = permiteEmpate;
		this.puntosPorPresentarse = puntosPorPresentarse;
		this.puntosPorGanar = puntosPorGanar;
		this.puntosPorEmpate = puntosPorEmpate;
		this.sistemaPuntuacion = sistemaPuntuacion;
		this.puntosPorAbandono = puntosPorAbandono;
		this.cantidadMaximaSets = cantidadMaximaSets;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	public Integer getDeporte() {
		return deporte;
	}
	public void setDeporte(Integer deporte) {
		this.deporte = deporte;
	}
	public List<Pair> getLugares() {
		return lugares;
	}
	public void setLugares(List<Pair> lugares) {
		this.lugares = lugares;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getSistemaPuntuacion() {
		return sistemaPuntuacion;
	}
	public void setSistemaPuntuacion(String sistemaPuntuacion) {
		this.sistemaPuntuacion = sistemaPuntuacion;
	}
	public String getReglamento() {
		return reglamento;
	}
	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
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
	public Integer getPuntosPorGanar() {
		return puntosPorGanar;
	}
	public void setPuntosPorGanar(Integer puntosPorGanar) {
		this.puntosPorGanar = puntosPorGanar;
	}
	public Integer getPuntosPorEmpate() {
		return this.puntosPorEmpate;
	}
	public void setPuntosPorEmpate(Integer puntosPorEmpate) {
		this.puntosPorEmpate = puntosPorEmpate;
	}
	public void setPuntosPorAbandono(Integer puntosPorAbandono) {
		this.puntosPorAbandono = puntosPorAbandono;
	}
	public Integer getPuntosPorAbandono() {
		return this.puntosPorAbandono;
	}
	public void setCantidadMaximaSets(Integer cantidadMaximaSets) {
		this.cantidadMaximaSets =  cantidadMaximaSets;
	}
	public Integer getCantidadMaximaSets() {
		return this.cantidadMaximaSets;
	}
	
}
