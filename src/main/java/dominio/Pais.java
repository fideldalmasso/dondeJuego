package dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dj.pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@OneToMany
	@JoinColumn(name="idPais")
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
