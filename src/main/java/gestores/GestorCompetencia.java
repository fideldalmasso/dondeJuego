package gestores;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daos.CompetenciaDAO;
import daos.CompetenciaLugarDAO;
import daos.DeporteDAO;
import daos.ModalidadDAO;
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
	
	
	public GestorCompetencia() {
		this.cd = new CompetenciaDAO();
		this.glr = new GestorLugarRealizacion();
		this.gu = new GestorUsuario();
		this.md = new ModalidadDAO();
		this.cld = new CompetenciaLugarDAO();
		this.dd = new DeporteDAO();
	}
	
	public Competencia crearCompetencia(CompetenciaDTO cdto) {
		List<Competencia> competencias= cd.getAllCompetencias();
		if(competencias.stream().filter(c -> c.getNombre().equals(cdto.getNombre())).count()>0); //Agregar mensaje de error
		
		Competencia compe = new Competencia();
		
		compe.setNombre(cdto.getNombre());
		
		compe.setEstado(EstadoCompetencia.CREADA);
		
		compe.setReglamento(cdto.getReglamento());
		
		Deporte d = dd.get(cdto.getDeporte());
		if(d==null); // Agregar mensaje de error
		compe.setDeporte(d);
		
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
		if(m.equals(null)); //Agregar mensaje de error
		
		md.saveModalidad(m);
		compe.setModalidad(m);
		
		(new GestorAutenticacion()).getUsuario().getCompetencias().add(compe);
		
		compe.setUsuario((new GestorAutenticacion()).getUsuario());
		
		cd.save(compe);
		
		for(Pair p : cdto.getLugares()){
			LugarRealizacion l = glr.getLugarRealizacion(p.getFirst());
			if(l==null); //Agregar mensaje de error
			CompetenciaLugar cl = new CompetenciaLugar(compe, l, p.getSecond());
			compe.getLugares().add(cl);
			cld.save(cl);
		}
		
		return compe;
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
