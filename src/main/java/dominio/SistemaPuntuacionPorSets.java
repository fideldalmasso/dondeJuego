package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.sistemaPuntuacionPorSets")
@PrimaryKeyJoinColumn(name = "idSistemaPuntuacion")
public class SistemaPuntuacionPorSets extends SistemaPuntuacion {
	@Column(name="cantidadMaximaDeSets")
	private Integer cantidadMaximaDeSets;
	public SistemaPuntuacionPorSets() {
		super();
	}
	public SistemaPuntuacionPorSets(Integer id, Integer cantidadMaximaDeSets) {
		super(id);
		this.cantidadMaximaDeSets = cantidadMaximaDeSets;
	}

	public Integer getCantidadMaximaDeSets() {
		return cantidadMaximaDeSets;
	}

	public void setCantidadMaximaDeSets(Integer cantidadMaximaDeSets) {
		this.cantidadMaximaDeSets = cantidadMaximaDeSets;
	}
	
}
