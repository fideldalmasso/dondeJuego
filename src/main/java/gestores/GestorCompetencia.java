package gestores;

import java.util.List;

import daos.CompetenciaDao;
import dominio.*;
import dtos.CompetenciaDTO;
import enumerados.EstadoCompetencia;

public class GestorCompetencia {
	private CompetenciaDao cd;
	public GestorCompetencia() {
		cd= new CompetenciaDao();
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
		
		compe
		
	}

}
