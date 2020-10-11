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
public class Set {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="puntajeA")
	private Integer puntajeA;
	@Column(name="puntajeB")
	private Integer puntajeB;
	@ManyToOne
	@JoinColumn(name="idResultado")
	private ResultadoSets resultado = new ResultadoSets();
	
	public Set(Integer id,Integer puntajeA, Integer puntajeB) {
		super();
		this.id = id;
		this.puntajeA = puntajeA;
		this.puntajeB = puntajeB;
	}
	public Set(Integer puntajeA, Integer puntajeB) {
		super();
		this.puntajeA = puntajeA;
		this.puntajeB = puntajeB;
	}
	public Set(Integer id) {
		super();
		this.id = id;
	}
	public Set() {
		super();
	}
	public Integer getpuntajeA() {
		return puntajeA;
	}
	public void setpuntajeA(Integer puntajeA) {
		this.puntajeA = puntajeA;
	}
	public Integer getpuntajeB() {
		return puntajeB;
	}
	public void setpuntajeB(Integer puntajeB) {
		this.puntajeB = puntajeB;
	}
}

