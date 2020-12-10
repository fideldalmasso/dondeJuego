package dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.sistemaPuntuacionPorResultadoFinal")
public class SistemaPuntuacionPorResultadoFinal extends SistemaPuntuacion {
	public SistemaPuntuacionPorResultadoFinal() {
		super();
	}
}
