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
}
