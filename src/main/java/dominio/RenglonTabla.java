package dominio;

public class RenglonTabla {
	private Integer id;
	private Integer partidosEmpatados;
	private Integer partidosGanados;
	private Integer partidosPerdidos;
	private Integer tantosAFavor;
	private Integer tantosEnContra;
	private Participante participante;
	
	public RenglonTabla(Integer id,Integer partidosEmpatados, Integer partidosGanados, Integer partidosPerdidos,
			Integer tantosAFavor, Integer tantosEnContra, Participante participante) {
		super();
		this.id=id;
		this.partidosEmpatados = partidosEmpatados;
		this.partidosGanados = partidosGanados;
		this.partidosPerdidos = partidosPerdidos;
		this.tantosAFavor = tantosAFavor;
		this.tantosEnContra = tantosEnContra;
		this.participante = participante;
	}
	public RenglonTabla() {
		super();
	}
	public Integer getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public void setPartidosEmpatados(Integer partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public Integer getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(Integer partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public Integer getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(Integer partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public Integer getTantosAFavor() {
		return tantosAFavor;
	}
	public void setTantosAFavor(Integer tantosAFavor) {
		this.tantosAFavor = tantosAFavor;
	}
	public Integer getTantosEnContra() {
		return tantosEnContra;
	}
	public void setTantosEnContra(Integer tantosEnContra) {
		this.tantosEnContra = tantosEnContra;
	}
	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
