package dominio;

import java.sql.Timestamp;

public class RegistroSesion {
	private Integer id;
	private Timestamp horarioInicio;
	public RegistroSesion(Integer id, Timestamp horarioInicio) {
		super();
		this.id = id;
		this.horarioInicio = horarioInicio;
	}
	public RegistroSesion() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Timestamp horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
}
