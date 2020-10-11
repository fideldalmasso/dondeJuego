package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.sett")
public class Pair{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="puntajeA")
	private Integer first;
	@Column(name="puntajeB")
	private Integer second;
	@ManyToOne
	@JoinColumn(name="idResultado")
	private ResultadoSets resultado = new ResultadoSets();
	
	public Pair(Integer id,Integer first, Integer second) {
		super();
		this.id = id;
		this.first = first;
		this.second = second;
	}
	public Pair(Integer first, Integer second) {
		super();
		this.first = first;
		this.second = second;
	}
	public Pair(Integer id) {
		super();
		this.id = id;
	}
	public Pair() {
		super();
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	
	
}
