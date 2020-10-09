package dominio;

public class CompetenciaLugar {
	private Integer id;
	private Competencia competencia;
	private LugarRealizacion lugar;
	private Integer disponibilidad;
	public CompetenciaLugar(Integer id,Competencia competencia, LugarRealizacion lugar, Integer disponibilidad) {
		super();
		this.id=id;
		this.competencia = competencia;
		this.lugar = lugar;
		this.disponibilidad = disponibilidad;
	}
	public CompetenciaLugar() {
		super();
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public LugarRealizacion getLugar() {
		return lugar;
	}
	public void setLugar(LugarRealizacion lugar) {
		this.lugar = lugar;
	}
	public Integer getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
