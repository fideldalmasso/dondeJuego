package dominio;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="dj.resultadoSets")
public class ResultadoSets extends Resultado {
	@OneToMany
	@JoinColumn(name="idResultado")
	private List<Pair> sets;
	public ResultadoSets() {
		super();
	}
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
