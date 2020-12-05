package dtos;

import java.util.List;

import dominio.Pair;

public class ResultadoSetsDTO extends ResultadoDTO {
	private List<Pair> sets;

	public ResultadoSetsDTO(Integer idResultado, List<Pair> sets) {
		super(idResultado);
		this.sets = sets;
	}

	public List<Pair> getSets() {
		return sets;
	}

	public void setSets(List<Pair> sets) {
		this.sets = sets;
	}
	
	
	
}
