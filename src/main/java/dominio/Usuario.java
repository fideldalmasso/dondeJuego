package dominio;

import java.util.List;

import enumerados.TipoDocumento;

public class Usuario {
	private Integer id;
	private Boolean registrado;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private TipoDocumento tipoDocumento;
	private String numeroDocumento;
	private String email;
	private List<Competencia> competencias;
	private List<RegistroSesion> registros;
	private List<LugarRealizacion> lugares;
	private Localidad localidad;
	public Usuario(Integer id, Boolean registrado, String nombre, String apellido, String contrasenia,
			TipoDocumento tipoDocumento, String numeroDocumento, String email, List<Competencia> competencias,
			List<RegistroSesion> registros, List<LugarRealizacion> lugares, Localidad localidad) {
		super();
		this.id = id;
		this.registrado = registrado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.email = email;
		this.competencias = competencias;
		this.registros = registros;
		this.lugares = lugares;
		this.localidad = localidad;
	}
	public Usuario() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getRegistrado() {
		return registrado;
	}
	public void setRegistrado(Boolean registrado) {
		this.registrado = registrado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}
	public List<RegistroSesion> getRegistros() {
		return registros;
	}
	public void setRegistros(List<RegistroSesion> registros) {
		this.registros = registros;
	}
	public List<LugarRealizacion> getLugares() {
		return lugares;
	}
	public void setLugares(List<LugarRealizacion> lugares) {
		this.lugares = lugares;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}
