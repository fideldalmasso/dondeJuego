package dtos;

public class EncuentroDTO {
	private Integer idEncuentro;
	private String nombreParticipanteA;
	private String nombreParticipanteB;
	private ResultadoDTO rdto;
	private Integer fecha;
	private String lugar;
	
	public EncuentroDTO(Integer idEncuentro, String nombreParticipanteA, String nombreParticipanteB,
			ResultadoDTO rdto) {
		super();
		this.idEncuentro = idEncuentro;
		this.nombreParticipanteA = nombreParticipanteA;
		this.nombreParticipanteB = nombreParticipanteB;
		this.rdto = rdto;
	}
	
	
	public EncuentroDTO(Integer idEncuentro, String nombreParticipanteA, String nombreParticipanteB, ResultadoDTO rdto,
			Integer fecha, String lugar) {
		super();
		this.idEncuentro = idEncuentro;
		this.nombreParticipanteA = nombreParticipanteA;
		this.nombreParticipanteB = nombreParticipanteB;
		this.rdto = rdto;
		this.fecha = fecha;
		this.lugar = lugar;
	}


	public Integer getFecha() {
		return fecha;
	}


	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public Integer getIdEncuentro() {
		return idEncuentro;
	}
	public void setIdEncuentro(Integer idEncuentro) {
		this.idEncuentro = idEncuentro;
	}
	public String getNombreParticipanteA() {
		return nombreParticipanteA;
	}
	public void setNombreParticipanteA(String nombreParticipanteA) {
		this.nombreParticipanteA = nombreParticipanteA;
	}
	public String getNombreParticipanteB() {
		return nombreParticipanteB;
	}
	public void setNombreParticipanteB(String nombreParticipanteB) {
		this.nombreParticipanteB = nombreParticipanteB;
	}
	public ResultadoDTO getRdto() {
		return rdto;
	}
	public void setRdto(ResultadoDTO rdto) {
		this.rdto = rdto;
	}
	
	
}
