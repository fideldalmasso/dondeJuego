package dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
	public Resultado(Integer id, Timestamp fechaRegistro) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
	}
	public Resultado(Integer id) {
		super();
		this.id = id;
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
	
}
