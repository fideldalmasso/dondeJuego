package dtos;

public class ParticipanteDTO {
	private String nombre;
	private String email;
	private Integer idCompetencia;
	
	
	
	public ParticipanteDTO(String nombre, String email, Integer idCompetencia) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.idCompetencia = idCompetencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdCompetencia() {
		return idCompetencia;
	}
	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}
	
	
}
