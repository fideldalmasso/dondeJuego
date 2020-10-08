package dominio;

import java.sql.Timestamp;

public class RegistroSesion {
	private Integer id;
	private Timestamp horarioInicio;
	private Usuario usuario;
	public RegistroSesion(Integer id, Timestamp horarioInicio, Usuario usuario) {
		super();
		this.id = id;
		this.horarioInicio = horarioInicio;
		this.usuario=usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
