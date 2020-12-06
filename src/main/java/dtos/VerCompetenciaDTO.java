package dtos;

import java.util.List;

import enumerados.EstadoCompetencia;

public class VerCompetenciaDTO {
	private String nombre;
	private String modalidad;
	private String deporte;
	private String estado;
	private List<String> participantes;
	private List<EncuentroDTO> proximosEncuetros;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<String> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<String> participantes) {
		this.participantes = participantes;
	}
	public List<EncuentroDTO> getProximosEncuetros() {
		return proximosEncuetros;
	}
	public void setProximosEncuetros(List<EncuentroDTO> proximosEncuetros) {
		this.proximosEncuetros = proximosEncuetros;
	}
	
	public void setEstado(EstadoCompetencia estado) {
		switch(estado) {
			case CREADA:
				this.estado = "Creada";
				break;
			case PLANIFICADA:
				this.estado = "Planificada";
				break;
			case ENDISPUTA:
				this.estado = "En disputa";
				break;
			case FINALIZADA:
				this.estado = "Finalizada";				
		}
	}
	
}
