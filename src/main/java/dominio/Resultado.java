package dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="dj.resultado")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	@Column(name="fechaRegistro")
	protected Timestamp fechaRegistro;
	@ManyToOne
	@JoinColumn(name="idEncuentro")
	protected Encuentro encuentro;
	
	public Resultado(Integer id, Timestamp fechaRegistro) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
	}
	public Resultado(Timestamp fechaRegistro) {
		super();
		this.fechaRegistro = fechaRegistro;
	}
	public Resultado() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Encuentro getEncuentro() {
		return encuentro;
	}
	public void setEncuentro(Encuentro encuentro) {
		this.encuentro = encuentro;
	}
	
}
