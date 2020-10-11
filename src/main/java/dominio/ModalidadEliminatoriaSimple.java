package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.modalidadEliminatoriaSimple")
@PrimaryKeyJoinColumn(name = "idModalidad")
public class ModalidadEliminatoriaSimple extends Modalidad {
	public ModalidadEliminatoriaSimple() {
		super();
	}
}
