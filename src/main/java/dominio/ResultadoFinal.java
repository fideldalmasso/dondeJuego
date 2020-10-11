package dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dj.resultadoFinal")
public class ResultadoFinal extends Resultado {
	@Column(name="empate")
	private Boolean empate; 
	@Column(name="ganaA")
	private Boolean ganaA;
	@Column(name="ganaB")
	private Boolean ganaB;
	
	public ResultadoFinal(Integer id, Timestamp fechaRegistro, Boolean empate, Boolean ganaA, Boolean ganaB) {
		super(id, fechaRegistro);
		this.empate = empate;
		this.ganaA = ganaA;
		this.ganaB = ganaB;
	}
	public ResultadoFinal(Timestamp fechaRegistro, Boolean empate, Boolean ganaA, Boolean ganaB) {
		super(fechaRegistro);
		this.empate = empate;
		this.ganaA = ganaA;
		this.ganaB = ganaB;
	}
	public ResultadoFinal() {
		super();
	}
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
	
}
