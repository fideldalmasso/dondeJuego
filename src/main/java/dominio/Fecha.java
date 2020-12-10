package dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dj.fecha")
public class Fecha {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany(mappedBy="fecha",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Encuentro> encuentros;
	@Column(name="tipoRonda")
	private Integer numero;
	@ManyToOne
	@JoinColumn(name="idFixture")
	private Fixture fixture;
	
	public Fecha(Set<Encuentro> encuentros, Integer id, Integer numero) {
		super();
		this.encuentros = encuentros;
		this.id = id;
		this.numero = numero;
	}
	public Fecha(Set<Encuentro> encuentros,Integer numero) {
		super();
		this.encuentros = encuentros;
		this.numero = numero;
	}
	public Fecha() {
		super();
		this.encuentros=new HashSet<Encuentro>();
	}
	public Set<Encuentro> getEncuentros() {
		return encuentros;
	}
	public void setEncuentros(Set<Encuentro> encuentros) {
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
	public void addEncuentro(Encuentro encuentro) {
		this.encuentros.add(encuentro);
	}
	public Fixture getFixture() {
		return fixture;
	}
	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	
}
