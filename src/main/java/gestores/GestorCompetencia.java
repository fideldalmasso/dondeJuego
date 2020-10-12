package gestores;

import java.util.List;


import daos.CompetenciaDAO;
import daos.CompetenciaLugarDAO;
import daos.DeporteDAO;
import daos.ModalidadDAO;
import daos.SistemaPuntuacionDAO;
import dominio.*;
import dtos.CompetenciaDTO;
import enumerados.EstadoCompetencia;

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
	
	public Mensaje crearCompetencia(CompetenciaDTO cdto) {
		
		Mensaje mensaje = new Mensaje();
		
		List<Competencia> competencias= cd.getAllCompetencias();
		Competencia compe = new Competencia();
		if(competencias.stream().filter(c -> c.getNombre().equals(cdto.getNombre())).count()!=0)
			mensaje.getMensaje().add("Ya existe el nombre elegido, ingrese otro");
		else {
			mensaje.getMensaje().add("1");
		}
		compe.setNombre(cdto.getNombre());
		
		compe.setEstado(EstadoCompetencia.CREADA);
		
		if(cdto.getReglamento()==null) {
			mensaje.getMensaje().add("Ingrese un reglamento");
		}else {
			mensaje.getMensaje().add("1");
			compe.setReglamento(cdto.getReglamento());
		}
			
		
		Deporte d = dd.get(cdto.getDeporte());
		if(d==null) {
			mensaje.getMensaje().add("Deporte inexistente");
		}else {
			mensaje.getMensaje().add("1");
			compe.setDeporte(d);
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
			mensaje.getMensaje().add("Modalidad inexistente");
		}else {
			mensaje.getMensaje().add("1");
			md.save(m);
			compe.setModalidad(m);
		}
		
		SistemaPuntuacion s;
		switch(cdto.getSistemaPuntuacion()) {
			case "Puntuacion":
				s = new SistemaPuntuacionPorPuntuacion(cdto.getPuntosPorAbandono());
				break;
			case "Resultado Final":
				s = new SistemaPuntuacionPorResultadoFinal();
				break;
			case "Sets":
				s = new SistemaPuntuacionPorSets(cdto.getCantidadMaximaSets());
				break;
			default:
				s=null;
				break;
		}
		if(s.equals(null)) {
			mensaje.getMensaje().add("Sistema puntuacion inexistente");
		}else {
			mensaje.getMensaje().add("1");
			sd.save(s);
			compe.setSistemaPuntuacion(s);
		}
		
		(new GestorAutenticacion()).getUsuario().getCompetencias().add(compe);
		
		compe.setUsuario((new GestorAutenticacion()).getUsuario());
		
		cd.save(compe);
		
		for(Pair p : cdto.getLugares()){
			LugarRealizacion l = glr.getLugarRealizacion(p.getFirst());
			CompetenciaLugar cl = new CompetenciaLugar(compe, l, p.getSecond());
			compe.getLugares().add(cl);
			cld.save(cl);
		}
		
		return mensaje;
	}
	
	public Deporte crearDeporte(String nombre) {
		Deporte deporte = new Deporte(nombre);
		dd.save(deporte);
		return deporte;
	}
	
	public List<Deporte> getAllDeportes(){
	return dd.getAll();
 }

}
