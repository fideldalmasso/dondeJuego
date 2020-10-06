package dominio;

public class Liga extends Modalidad {
	private Boolean permiteEmpate;
	private Integer puntosPorPresentarse;
	private Integer puntosPorEmpate;
	private Integer puntosPorGanar;
	public Liga() {
		super();
	}
	public Liga(Integer id,Boolean permiteEmpate, Integer puntosPorPresentarse, Integer puntosPorEmpate, Integer puntosPorGanar) {
		super(id);
		this.permiteEmpate = permiteEmpate;
		this.puntosPorPresentarse = puntosPorPresentarse;
		this.puntosPorEmpate = puntosPorEmpate;
		this.puntosPorGanar = puntosPorGanar;
	}
	public Boolean getPermiteEmpate() {
		return permiteEmpate;
	}
	public void setPermiteEmpate(Boolean permiteEmpate) {
		this.permiteEmpate = permiteEmpate;
	}
	public Integer getPuntosPorPresentarse() {
		return puntosPorPresentarse;
	}
	public void setPuntosPorPresentarse(Integer puntosPorPresentarse) {
		this.puntosPorPresentarse = puntosPorPresentarse;
	}
	public Integer getPuntosPorEmpate() {
		return puntosPorEmpate;
	}
	public void setPuntosPorEmpate(Integer puntosPorEmpate) {
		this.puntosPorEmpate = puntosPorEmpate;
	}
	public Integer getPuntosPorGanar() {
		return puntosPorGanar;
	}
	public void setPuntosPorGanar(Integer puntosPorGanar) {
		this.puntosPorGanar = puntosPorGanar;
	}
	
}
