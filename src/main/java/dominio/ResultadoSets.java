package dominio;

import java.sql.Timestamp;
import java.util.List;



public class ResultadoSets extends Resultado {
	private List<Pair<Integer,Integer>> sets;

	public List<Pair<Integer, Integer>> getSets() {
		return sets;
	}

	public void setSets(List<Pair<Integer, Integer>> sets) {
		this.sets = sets;
	}

	public ResultadoSets(Integer id, Timestamp fechaRegistro, List<Pair<Integer, Integer>> sets) {
		super(id, fechaRegistro);
		this.sets = sets;
	}
	
	
}
