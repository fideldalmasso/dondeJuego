package dominio;

public class SistemaPuntuacionPorPuntuacion extends SistemaPuntuacion {
	private Integer puntosPorAbandono;

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
