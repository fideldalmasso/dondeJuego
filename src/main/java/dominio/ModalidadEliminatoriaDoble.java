package dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.modalidadEliminatoriaDoble")
@PrimaryKeyJoinColumn(name = "idModalidad")
public class ModalidadEliminatoriaDoble extends Modalidad {
	public ModalidadEliminatoriaDoble() {
		super();
	}
}
