package dominio;

import java.sql.Timestamp;
import java.util.List;

import enumerados.EstadoCompetencia;

public class Competencia {
	private Integer id;
	private String nombre;
	private EstadoCompetencia estado;
	private String reglamento;
	private Timestamp fechaInicio;
	private Timestamp fechaFin;
	private Timestamp fechaHoraBajaLogica;
	private Deporte deporte;
	private SistemaPuntuacion sistemaPuntuacion;
	private Modalidad modalidad;
	private List<CompetenciaLugar> lugares;
	private List<Participante> participantes;
	private Fixture fixture;
}
