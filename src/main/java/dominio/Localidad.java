package dominio;

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
@Table(name="dj.localidad")
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;
	@Column(name="nombre")
	private String nombre;
	public Localidad(Integer id, Provincia provincia, String nombre) {
		super();
		this.id = id;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	public Localidad(Provincia provincia, String nombre) {
		super();
		this.id = id;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	public Localidad() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
