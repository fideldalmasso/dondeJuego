package dominio;

import java.util.List;

public class Pais {
	private Integer id;
	private String nombre;
	private List<Provincia> provincias;
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
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	public Pais() {
		super();
	}
	public Pais(Integer id, String nombre, List<Provincia> provincias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincias = provincias;
	}
	public Pais(String nombre, List<Provincia> provincias) {
		super();
		this.nombre = nombre;
		this.provincias = provincias;
	}
}
