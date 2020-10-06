package dominio;

public class Localidad {
	private Integer id;
	private Provincia provincia;
	private String nombre;
	public Localidad(Integer id, Provincia provincia, String nombre) {
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
