package dominio;

import java.util.List;

public class Provincia {
	private Integer id;
	private Pais pais;
	private String nombre;
	private List<Localidad> localidades;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Localidad> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
	public Provincia(Integer id, Pais pais, String nombre, List<Localidad> localidades) {
		super();
		this.id = id;
		this.pais = pais;
		this.nombre = nombre;
		this.localidades = localidades;
	}
	public Provincia(Pais pais, String nombre, List<Localidad> localidades) {
		super();
		this.id = id;
		this.pais = pais;
		this.nombre = nombre;
		this.localidades = localidades;
	}
	public Provincia() {
		super();
	}
}
