package dtos;

public class VerInterfazCompetenciaDTO {

	private Integer idCompetencia;
	private String nombre;
	private String deporte;
	private String modalidad;
	private String estado;
	
	

	public VerInterfazCompetenciaDTO(Integer idCompetencia, String nombre, String deporte, String modalidad,
			String estado) {
		super();
		this.idCompetencia = idCompetencia;
		this.nombre = nombre;
		this.deporte = deporte;
		this.modalidad = modalidad;
		this.estado = estado;
	}
	
	public VerInterfazCompetenciaDTO() {
		super();
	}
	
	public Integer getIdCompetencia() {
		return idCompetencia;
	}
	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
