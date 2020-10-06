package dominio;

import java.sql.Timestamp;
import java.util.List;

public class Fixture {
	private Integer id;
	private Timestamp fechaCreacion;
	private List<Fecha> fechas;
	public Fixture() {
		super();
	}
	public Fixture(Integer id, Timestamp fechaCreacion, List<Fecha> fechas) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.fechas = fechas;
	}
	public List<Fecha> getFechas() {
		return fechas;
	}
	public void setFechas(List<Fecha> fechas) {
		this.fechas = fechas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
