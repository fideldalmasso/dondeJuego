package dominio;

import java.sql.Timestamp;

public class ResultadoFinal extends Resultado {
	private Boolean empate; 
	private Boolean ganaA;
	private Boolean ganaB;
	public Boolean getEmpate() {
		return empate;
	}
	public void setEmpate(Boolean empate) {
		this.empate = empate;
	}
	public Boolean getGanaA() {
		return ganaA;
	}
	public void setGanaA(Boolean ganaA) {
		this.ganaA = ganaA;
	}
	public Boolean getGanaB() {
		return ganaB;
	}
	public void setGanaB(Boolean ganaB) {
		this.ganaB = ganaB;
	}
	public ResultadoFinal(Integer id, Timestamp fechaRegistro, Boolean empate, Boolean ganaA, Boolean ganaB) {
		super(id, fechaRegistro);
		this.empate = empate;
		this.ganaA = ganaA;
		this.ganaB = ganaB;
	}
	
	
}
