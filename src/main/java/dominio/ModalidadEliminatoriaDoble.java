package dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.modalidadEliminatoriaDoble")
public class ModalidadEliminatoriaDoble extends Modalidad {
	public ModalidadEliminatoriaDoble() {
		super();
	}
	@Override
	public String toString() {
		return "Eliminatoria doble";
	}
	
}
