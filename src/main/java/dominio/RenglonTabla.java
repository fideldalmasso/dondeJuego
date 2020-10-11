package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dj.renglonTabla")
public class RenglonTabla {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="partidosEmpatados")
	private Integer partidosEmpatados;
	@Column(name="partidosGanados")
	private Integer partidosGanados;
	@Column(name="partidosPerdidos")
	private Integer partidosPerdidos;
	@Column(name="tantosAFavor")
	private Integer tantosAFavor;
	@Column(name="tantosEnContra")
	private Integer tantosEnContra;
	@OneToOne
	@JoinColumn(name="idParticipante")
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
	public RenglonTabla(Integer id) {
		super();
		this.id=id;
		this.partidosEmpatados = null;
		this.partidosGanados = null;
		this.partidosPerdidos = null;
		this.tantosAFavor = null;
		this.tantosEnContra = null;
		this.participante = null;
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
