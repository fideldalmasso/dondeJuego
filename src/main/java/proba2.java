import java.util.List;

import daos.CompetenciaDAO;
import dominio.Pair;
import dtos.CompetenciaDTO;
import gestores.GestorCompetencia;

public class proba2 {

	public static void main(String[] args) {
		CompetenciaDAO cd= new CompetenciaDAO();
		/*
		 * CompetenciaDTO(String nombre, Integer deporte, List<Pair> lugares, String modalidad, String reglamento,
			Boolean permiteEmpate, Integer puntosPorPresentarse, Integer puntosPorGanar,Integer puntosPorEmpate)
		 */
		GestorCompetencia gc = new GestorCompetencia();
		gc.crearCompetencia(new CompetenciaDTO(null, null, null, null, null, null, null, null, null));
		System.out.println(cd.getAllCompetencias());
	}

}
