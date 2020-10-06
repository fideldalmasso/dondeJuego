package dominio;

public class SistemaPuntuacionPorSets extends SistemaPuntuacion {
	private Integer cantidadMaximaDeSets;

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
