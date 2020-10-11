package dominio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.lugarRealizacion")
public class LugarRealizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	@ManyToMany
	@JoinTable(name = "dj.deporteLugar", 
	  joinColumns = @JoinColumn(name = "idLugar"), 
	  inverseJoinColumns = @JoinColumn(name = "idDeporte"))
	private Set<Deporte> deportes;
	public LugarRealizacion() {
		super();
		deportes = new HashSet<Deporte>();
	}
	public LugarRealizacion(String nombre, String descripcion, Usuario usuario, Set<Deporte> deportes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.deportes = deportes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Set<Deporte> getDeportes() {
		return deportes;
	}
	public void setDeportes(Set<Deporte> deportes) {
		this.deportes = deportes;
	}
}
