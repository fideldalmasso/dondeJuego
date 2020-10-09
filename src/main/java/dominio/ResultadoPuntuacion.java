package dominio;

import java.sql.Timestamp;

public class ResultadoPuntuacion extends Resultado {
	private Integer puntajeFinalA;
	private Integer puntajeFinalB;
	public ResultadoPuntuacion() {
		super();
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
	public ResultadoPuntuacion(Integer id, Timestamp fechaRegistro, Integer puntajeFinalA, Integer puntajeFinalB) {
		super(id, fechaRegistro);
		this.puntajeFinalA = puntajeFinalA;
		this.puntajeFinalB = puntajeFinalB;
	}
	
}
