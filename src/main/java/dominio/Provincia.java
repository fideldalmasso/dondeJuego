package dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="dj.provincia")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idPais")
	private Pais pais;
	@Column(name="nombre")
	private String nombre;
	@OneToMany(mappedBy="localidad")
	private List<Localidad> localidades;
	
	public Provincia(Integer id, Pais pais, String nombre, List<Localidad> localidades) {
		super();
		this.id = id;
		this.pais = pais;
		this.nombre = nombre;
		this.localidades = localidades;
	}
	public Provincia(Pais pais, String nombre, List<Localidad> localidades) {
		super();
		this.pais = pais;
		this.nombre = nombre;
		this.localidades = localidades;
	}
	public Provincia() {
		super();
	}
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
}
