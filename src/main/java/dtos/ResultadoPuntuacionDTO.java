package dtos;

public class ResultadoPuntuacionDTO extends ResultadoDTO {
	private Integer puntajeFinalA;
	private Integer puntajeFinalB;
	public ResultadoPuntuacionDTO(Integer puntajeFinalA, Integer puntajeFinalB, Integer idResultado) {
		super(idResultado);
		this.puntajeFinalA = puntajeFinalA;
		this.puntajeFinalB = puntajeFinalB;
	}
	public Integer getPuntajeFinalA() {
		return puntajeFinalA;
	}
	public void setPuntajeFinalA(Integer puntajeFinalA) {
		this.puntajeFinalA = puntajeFinalA;
	}
	public Integer getPuntajeFinalB() {
		return puntajeFinalB;
	}
	public void setPuntajeFinalB(Integer puntajeFinalB) {
		this.puntajeFinalB = puntajeFinalB;
	}
	
	
}
