package dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dj.resultadoPuntuacion")
public class ResultadoPuntuacion extends Resultado {
	@Column(name="puntajeFinalA")
	private Integer puntajeFinalA;
	@Column(name="puntajeFinalB")
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
