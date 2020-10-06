package dominio;

import java.util.List;

public class Fecha {
	private List<Encuentro> encuentros;
	private Integer id;
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
