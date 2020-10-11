package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dj.sistemaPuntuacionPorSets")
@PrimaryKeyJoinColumn(name = "idSistemaPuntuacion")
public class SistemaPuntuacionPorSets extends SistemaPuntuacion {
	@Column(name="cantidadMaximaDeSets")
	private Integer cantidadMaximaDeSets;
	
	public SistemaPuntuacionPorSets(Integer id, Integer cantidadMaximaDeSets) {
		super(id);
		this.cantidadMaximaDeSets = cantidadMaximaDeSets;
	}
	public SistemaPuntuacionPorSets(Integer cantidadMaximaDeSets) {
		super();
		this.cantidadMaximaDeSets = cantidadMaximaDeSets;
	}
	public SistemaPuntuacionPorSets() {
		super();
	}
	public Integer getCantidadMaximaDeSets() {
		return cantidadMaximaDeSets;
	}

	public void setCantidadMaximaDeSets(Integer cantidadMaximaDeSets) {
		this.cantidadMaximaDeSets = cantidadMaximaDeSets;
	}
	
}
