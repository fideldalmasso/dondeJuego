package dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dj.fecha")
public class Fecha {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	@JoinColumn(name="idFecha")
	private List<Encuentro> encuentros;
	@Column(name="tipoRonda")
	private Integer numero;
	public Fecha(List<Encuentro> encuentros, Integer id, Integer numero) {
		super();
		this.encuentros = encuentros;
		this.id = id;
		this.numero = numero;
	}
	public Fecha(Integer id, Integer numero) {
		super();
		this.id = id;
		this.numero = numero;
	}
	public Fecha() {
		super();
	}
	public List<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(List<Encuentro> encuentros) {
		this.encuentros = encuentros;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
