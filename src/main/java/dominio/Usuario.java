package dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumerados.TipoDocumento;

@Entity
@Table(name="dj.usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="contrasenia")
	private String contrasenia;
	@Column(name="tipoDocumento")
	private TipoDocumento tipoDocumento;
	@Column(name="dni")
	private String numeroDocumento;
	@Column(name="email")
	private String email;
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private Set<Competencia> competencias;
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private Set<RegistroSesion> registros;
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private Set<LugarRealizacion> lugares;
	@ManyToOne
	@JoinColumn(name="idLocalidad")
	private Localidad localidad;
	
	public Usuario(Integer id, String nombre, String apellido, String contrasenia,
			TipoDocumento tipoDocumento, String numeroDocumento, String email, Set<Competencia> competencias,
			Set<RegistroSesion> registros, Set<LugarRealizacion> lugares, Localidad localidad) {
		super();
		this.id = id;
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
		this.competencias =  new HashSet<Competencia>();
		this.registros = new HashSet<RegistroSesion>();
		this.lugares =  new HashSet<LugarRealizacion>();
	}
	public Usuario(String nombre, String apellido, String contrasenia,
			TipoDocumento tipoDocumento, String numeroDocumento, String email, Set<Competencia> competencias,
			Set<RegistroSesion> registros, Set<LugarRealizacion> lugares, Localidad localidad) {
		super();
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
		this.competencias =  new HashSet<Competencia>();
		this.registros = new HashSet<RegistroSesion>();
		this.lugares =  new HashSet<LugarRealizacion>();
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
	public Set<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}
	public Set<RegistroSesion> getRegistros() {
		return registros;
	}
	public void setRegistros(Set<RegistroSesion> registros) {
		this.registros = registros;
	}
	public Set<LugarRealizacion> getLugares() {
		return lugares;
	}
	public void setLugares(Set<LugarRealizacion> lugares) {
		this.lugares = lugares;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}
