package gestores;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daos.CompetenciaDao;
import dominio.*;
import dtos.CompetenciaDTO;
import enumerados.EstadoCompetencia;

public class GestorCompetencia {
	private CompetenciaDao cd;
	private GestorLugarRealizacion glr;
	private GestorUsuario gu;
	public GestorCompetencia() {
		cd= new CompetenciaDao();
		glr = new GestorLugarRealizacion();
		gu = new GestorUsuario();
	}
	
	public Competencia crearCompetencia(CompetenciaDTO cdto) {
		List<Competencia> competencias= cd.getAllCompetencias();
		if(competencias.stream().filter(c -> c.getNombre().equals(cdto.getNombre())).count()>0); //Agregar mensaje de error
			
		
		Competencia compe = new Competencia();
		
		compe.setNombre(cdto.getNombre());
		
		compe.setEstado(EstadoCompetencia.CREADA);
		
		compe.setReglamento(cdto.getReglamento());
		
		Deporte d = cd.getDeporte(cdto.getDeporte());
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
		cd.saveModalidad(m);
		compe.setModalidad(m);
		
		
		
		
		//(new GestorAutenticacion()).getUsuario().getCompetencias().add(compe);
		
		for(Pair p : cdto.getLugares()){
			LugarRealizacion l = glr.getLugarRealizacion(p.getFirst());
			if(l==null) System.out.println("F");
			CompetenciaLugar cl = new CompetenciaLugar(compe, l, p.getSecond());
			compe.getLugares().add(cl);	
	//		cd.save(cl);
		}
	//	cd.update(compe);
		cd.save(compe);
		//gu.guardar();
		return compe;
	}
	
	public Deporte crearDeporte(String nombre) {
		Deporte deporte = new Deporte(nombre);
		cd.saveDeporte(deporte);
		return deporte;
	}
	
	public List<Deporte> getAllDeportes(){
	return this.cd.getAllDeportes();
 }

}
