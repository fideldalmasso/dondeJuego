package dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.modalidadEliminatoriaSimple")
public class ModalidadEliminatoriaSimple extends Modalidad {
	public ModalidadEliminatoriaSimple() {
		super();
	}
	@Override
	public String toString() {
		return "Eliminatoria Simple";
	}
	
}
