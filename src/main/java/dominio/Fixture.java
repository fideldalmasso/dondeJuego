package dominio;

import java.sql.Timestamp;

public class Fixture {
	private Integer id;
	private Timestamp fechaCreacion;
	public Fixture(Integer id, Timestamp fechaCreacion) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
	}
	public Fixture() {
		super();
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
