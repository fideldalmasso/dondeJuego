package dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.registroSesion")
public class RegistroSesion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="horaInicio")
	private Timestamp horarioInicio;
	@ManyToOne
	@JoinColumn(name="documentoUsuario")
	private Usuario usuario;
	
	public RegistroSesion(Integer id, Timestamp horarioInicio, Usuario usuario) {
		super();
		this.id = id;
		this.horarioInicio = horarioInicio;
		this.usuario=usuario;
	}
	public RegistroSesion(Timestamp horarioInicio, Usuario usuario) {
		super();
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
