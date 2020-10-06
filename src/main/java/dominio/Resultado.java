package dominio;

import java.sql.Timestamp;

public class Resultado {
	protected Integer id;
	protected Timestamp fechaRegistro;
	public Resultado(Integer id, Timestamp fechaRegistro) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
	}
	public Resultado(Integer id) {
		super();
		this.id = id;
	}
	public Resultado() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
