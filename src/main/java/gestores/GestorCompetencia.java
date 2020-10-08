package gestores;

import java.util.ArrayList;
import java.util.List;

import daos.CompetenciaDao;
import dominio.*;
import dtos.CompetenciaDTO;
import enumerados.EstadoCompetencia;

public class GestorCompetencia {
	private CompetenciaDao cd;
	private GestorLugarRealizacion lr;
	private GestorUsuario gu;
	public GestorCompetencia() {
		cd= new CompetenciaDao();
		lr = new GestorLugarRealizacion();
		gu = new GestorUsuario();
	}
	public void crearCompetencia(CompetenciaDTO cdto) {
		List<Competencia> competencias= cd.getAllCompetencias();
		if(competencias.stream().filter(c -> c.getNombre().equals(cdto.getNombre())).count()>0)
			System.out.println("F");
		Competencia compe = new Competencia();
		compe.setNombre(cdto.getNombre());
		compe.setEstado(EstadoCompetencia.CREADA);
		compe.setReglamento(cdto.getReglamento());
		Deporte d = cd.getDeporte(cdto.getDeporte());
		if(d==null) System.out.println("F");
		compe.setDeporte(d);
		CompetenciaLugar lugares = new CompetenciaLugar();
		for(Pair p : cdto.getLugares()) {
			LugarRealizacion l = lr.getLugarRealizacion(p.getFirst());
			if(l==null) System.out.println("F");
			CompetenciaLugar cl = new CompetenciaLugar(compe, l, p.getSecond());
			compe.getLugares().add(cl);
		}
		compe.setId(this.cd.save(compe));
		gu.guardar(new GestorAutenticacion().getUsuario().getCompetencias().add(compe));
	}

}
