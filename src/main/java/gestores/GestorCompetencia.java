package gestores;

import java.util.List;


import daos.CompetenciaDAO;
import daos.CompetenciaLugarDAO;
import daos.DeporteDAO;
import daos.ModalidadDAO;
import daos.SistemaPuntuacionDAO;
import dominio.*;
import dtos.CompetenciaDTO;
import dtos.ParticipanteDTO;
import enumerados.EstadoCompetencia;
import paneles.PanelAltaCompetencia.errores;

public class GestorCompetencia {
	private CompetenciaDAO cd;
	private ModalidadDAO md;
	private CompetenciaLugarDAO cld;
	private DeporteDAO dd;
	private GestorLugarRealizacion glr;
	private GestorUsuario gu;
	private SistemaPuntuacionDAO sd;
	
	
	public GestorCompetencia() {
		this.cd = new CompetenciaDAO();
		this.glr = new GestorLugarRealizacion();
		this.gu = new GestorUsuario();
		this.md = new ModalidadDAO();
		this.cld = new CompetenciaLugarDAO();
		this.dd = new DeporteDAO();
		this.sd = new SistemaPuntuacionDAO();
	}
	
	public Mensaje2<errores> crearCompetencia(CompetenciaDTO cdto) {
		
		Mensaje2<errores> mensaje = new Mensaje2<errores>();
		
		List<Competencia> competencias= cd.getAllCompetencias(); //TODO no se puede hacer una consulta que devuelva solo los nombres de las competencias?
		Competencia compe = new Competencia();
		if(cdto.getNombre()==null) {
			mensaje.put(errores.NOMBRE,"Ingrese el nombre de la competencia");
		}else if(competencias.stream().filter(c -> c.getNombre().equals(cdto.getNombre())).count()!=0)
			mensaje.put(errores.NOMBRE,"Ya existe el nombre elegido, ingrese otro");
	
		compe.setNombre(cdto.getNombre());
		
		compe.setEstado(EstadoCompetencia.CREADA);
		
		compe.setReglamento(cdto.getReglamento());
		
		Deporte d = dd.get(cdto.getDeporte());
		if(d==null) {
			mensaje.put(errores.DEPORTE,"Deporte inexistente");
		}else {
			compe.setDeporte(d);
		}
		
		if(cdto.getPermiteEmpate() && cdto.getPuntosPorEmpate()>cdto.getPuntosPorGanar()) {
			mensaje.put(errores.PUNTOSPOREMPATE, "La cantidad de puntos por empate no puede ser mayor que la cantidad de puntos por ganar.");
		}
		
		Modalidad m;
		switch(cdto.getModalidad()) {
			case "Liga":
				m = new ModalidadLiga(cdto.getPermiteEmpate(),
						cdto.getPuntosPorPresentarse(),
						cdto.getPuntosPorEmpate(),
						cdto.getPuntosPorGanar());
				break;
			case "Eliminatoria doble":
				m = new ModalidadEliminatoriaDoble();
				break;
			case "Eliminatoria simple":
				m = new ModalidadEliminatoriaSimple();
				break;
			default:
				m=null;
				break;
		}
		if(m.equals(null)){
			mensaje.put(errores.MODALIDAD,"Modalidad inexistente");
		}else {
			//md.save(m);
			compe.setModalidad(m);
		}
		
		SistemaPuntuacion s;
		switch(cdto.getSistemaPuntuacion()) {
			case "Puntuación":
				s = new SistemaPuntuacionPorPuntuacion(cdto.getPuntosPorAbandono());
				break;
			case "Resultado Final":
				s = new SistemaPuntuacionPorResultadoFinal();
				break;
			case "Sets":
				s = new SistemaPuntuacionPorSets(cdto.getCantidadMaximaSets());
				if(cdto.getCantidadMaximaSets()%2==0) 
					mensaje.put(errores.CANTIDADMAXIMASETS,"La cantidad de sets debe ser un número impar");
				
				break;
			default:
				s=null;
				break;
		}
		if(s.equals(null)) {
			mensaje.put(errores.SISTEMAPUNTUACION,"Sistema puntuación inexistente");
		}else {
			//sd.save(s);
			compe.setSistemaPuntuacion(s);
		}
		
		(new GestorAutenticacion()).getUsuario().getCompetencias().add(compe);
		
		if((new GestorAutenticacion()).getUsuario()==null) {
			mensaje.put(errores.USUARIO,"Ingrese con algun usuario");
		}else{
			compe.setUsuario((new GestorAutenticacion()).getUsuario());
		}
		
		if(cdto.getLugares().isEmpty()) {
			mensaje.put(errores.LUGAR,"Debe seleccionar al menos un lugar de realizacion");
		}else {
			for(Pair p : cdto.getLugares()){
				if(p.getSecond()<1) {
					mensaje.put(errores.LUGAR,"Debe seleccionar una disponibilidad mayor o igual a 1");
					break;
				}
			}
		}
		
		if(mensaje.getMensaje().isEmpty()) {
			for(Pair p : cdto.getLugares()){
				LugarRealizacion l = glr.getLugarRealizacion(p.getFirst());
				CompetenciaLugar cl = new CompetenciaLugar(compe, l, p.getSecond());
				compe.getLugares().add(cl);
			}
			cd.save(compe);
			mensaje.put(errores.EXITO,"Competencia agregada con exito");
			
		}
		
		
		return mensaje;
	}
	public void actualizarFixture(Competencia compe) {
		Integer contResultados=0, contEncuentros=0;
		for(Fecha f: compe.getFixture().getFechas()) {
			for(Encuentro e: f.getEncuentros()) {
				contEncuentros++;
				if(e.getVigente()!=null) contResultados++;
			}
		}
		if(contEncuentros.equals(contResultados)) compe.setEstado(EstadoCompetencia.FINALIZADA);
		else if (contResultados.equals(1)) compe.setEstado(EstadoCompetencia.ENDISPUTA);
		cd.update(compe);
	}
	public void agregarParticipante(Participante p, Competencia compe) {
		compe.getParticipantes().add(p);
		compe.setEstado(EstadoCompetencia.CREADA);
		compe.setFixture(null);
		cd.update(compe);
	}
	
	public Competencia verificarCompetencia(ParticipanteDTO pdto) {
		Competencia compe = cd.getCompetencia(pdto.getIdCompetencia());
		if(compe.getEstado().equals(EstadoCompetencia.CREADA) || compe.getEstado().equals(EstadoCompetencia.PLANIFICADA))
			return compe;
		return null;
	}
	
	public Deporte crearDeporte(String nombre) {
		Deporte deporte = new Deporte(nombre);
		dd.save(deporte);
		return deporte;
	}
	
	public List<Deporte> getAllDeportes(){
		return dd.getAll();
	}
	
	public Competencia getCompetencia(Integer id) {
		return (new CompetenciaDAO()).getCompetencia(id);
	}

}
