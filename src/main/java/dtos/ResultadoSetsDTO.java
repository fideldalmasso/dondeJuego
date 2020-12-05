package dtos;

import java.util.List;

import dominio.Pair;
import dominio.Set;

public class ResultadoSetsDTO extends ResultadoDTO {
	private List<Set> sets;

	public ResultadoSetsDTO(Integer idResultado, List<Set> sets) {
		super(idResultado);
		this.sets = sets;
	}

	public List<Set> getSets() {
		return sets;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
	
	
	
}
