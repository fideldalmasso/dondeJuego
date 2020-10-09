package dominio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LugarRealizacion {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Usuario usuario;
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
