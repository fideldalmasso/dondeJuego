package dominio;

import java.sql.Timestamp;
import java.util.List;



public class ResultadoSets extends Resultado {
	private List<Pair> sets;

	public List<Pair> getSets() {
		return sets;
	}

	public void setSets(List<Pair> sets) {
		this.sets = sets;
	}

	public ResultadoSets(Integer id, Timestamp fechaRegistro, List<Pair> sets) {
		super(id, fechaRegistro);
		this.sets = sets;
	}
	
	
}
