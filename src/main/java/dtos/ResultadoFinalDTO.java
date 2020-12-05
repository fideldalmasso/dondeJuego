package dtos;

public class ResultadoFinalDTO extends ResultadoDTO{
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
	public ResultadoFinalDTO(Integer idResultado, Boolean empate, Boolean ganaA, Boolean ganaB) {
		super(idResultado);
		this.empate = empate;
		this.ganaA = ganaA;
		this.ganaB = ganaB;
	}
	public ResultadoFinalDTO() {
		super();
	}
	
}
