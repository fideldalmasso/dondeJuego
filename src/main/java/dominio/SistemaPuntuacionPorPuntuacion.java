package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.sistemaPuntuacionPorPuntuacion")
@PrimaryKeyJoinColumn(name = "idSistemaPuntuacion")
public class SistemaPuntuacionPorPuntuacion extends SistemaPuntuacion {
	@Column(name="puntosPorAbandono")
	private Integer puntosPorAbandono;
	public SistemaPuntuacionPorPuntuacion() {
		super();
	}
	public SistemaPuntuacionPorPuntuacion(Integer id,Integer puntosPorAbandono) {
		super(id);
		this.puntosPorAbandono = puntosPorAbandono;
	}

	public Integer getPuntosPorAbandono() {
		return puntosPorAbandono;
	}

	public void setPuntosPorAbandono(Integer puntosPorAbandono) {
		this.puntosPorAbandono = puntosPorAbandono;
	}
	
}
