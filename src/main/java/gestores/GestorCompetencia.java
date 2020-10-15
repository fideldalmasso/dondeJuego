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
import gui.PanelAltaCompetencia2.errores;

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
	
	public Mensaje<errores> crearCompetencia(CompetenciaDTO cdto) {
		
		Mensaje<errores> mensaje = new Mensaje<errores>();
		
		List<Competencia> competencias= cd.getAllCompetencias(); //TODO no se puede hacer una consulta que devuelva solo los nombres de las competencias?
		Competencia compe = new Competencia();
		if(cdto.getNombre()==null || cdto.getNombre())
		else if(competencias.stream().filter(c -> c.getNombre().equals(cdto.getNombre())).count()!=0)
			mensaje.put(errores.NOMBRE,"Ya existe el nombre elegido, ingrese otro");
	
		compe.setNombre(cdto.getNombre());
		
		compe.setEstado(EstadoCompetencia.CREADA);
		
		if(cdto.getReglamento()==null) {
			mensaje.put(errores.REGLAMENTO,"Ingrese un reglamento"); //TODO  el reglamento es opcional creo
		}else {
			mensaje.put(errores.EXITO,"1");
			compe.setReglamento(cdto.getReglamento());
		}
			
		
		Deporte d = dd.get(cdto.getDeporte());
		if(d==null) {
			mensaje.put(errores.DEPORTE,"Deporte inexistente");
		}else {
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
			mensaje.put(errores.MODALIDAD,"Modalidad inexistente");
		}else {
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
			mensaje.put(errores.SISTEMAPUNTUACION,"Sistema puntuacion inexistente");
		}else {
			sd.save(s);
			compe.setSistemaPuntuacion(s);
		}
		
		(new GestorAutenticacion()).getUsuario().getCompetencias().add(compe);
		
		compe.setUsuario((new GestorAutenticacion()).getUsuario()); //TODO verificar si el usuario esta autenticado, por las dudas, nomas por el nullpointerexception
		
		cd.save(compe);
		
		for(Pair p : cdto.getLugares()){ //TODO y si la lista esta vacia o tiene lugares con disponibilidad invalida (un numero negativo por ej)?
			LugarRealizacion l = glr.getLugarRealizacion(p.getFirst());
			CompetenciaLugar cl = new CompetenciaLugar(compe, l, p.getSecond());
			compe.getLugares().add(cl);
			cld.save(cl);
		}
		
		if(mensaje.getMensaje().isEmpty())
			mensaje.put(errores.EXITO,"Competencia agregada con exito");
			
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
