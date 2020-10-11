package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="dj.modalidad")
public class Modalidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Modalidad(Integer id) {
		super();
		this.id = id;
	}


	public Modalidad() {
		super();
	}


}
