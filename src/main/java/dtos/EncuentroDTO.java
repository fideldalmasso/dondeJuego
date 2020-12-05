package dtos;

public class EncuentroDTO {
	private Integer idEncuentro;
	private String nombreParticipanteA;
	private String nombreParticipanteB;
	ResultadoDTO rdto;
	public EncuentroDTO(Integer idEncuentro, String nombreParticipanteA, String nombreParticipanteB,
			ResultadoDTO rdto) {
		super();
		this.idEncuentro = idEncuentro;
		this.nombreParticipanteA = nombreParticipanteA;
		this.nombreParticipanteB = nombreParticipanteB;
		this.rdto = rdto;
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
