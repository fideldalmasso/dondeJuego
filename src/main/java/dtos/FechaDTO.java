package dtos;

import java.util.List;

public class FechaDTO {
	private Integer idFecha;
	private Integer numero;
	private List<EncuentroDTO> encuentros;
	public FechaDTO(Integer idFecha, Integer numero, List<EncuentroDTO> encuentros) {
		super();
		this.idFecha = idFecha;
		this.numero = numero;
		this.encuentros = encuentros;
	}
	
	public FechaDTO() {
		super();
	}

	public Integer getIdFecha() {
		return idFecha;
	}

	public void setIdFecha(Integer idFecha) {
		this.idFecha = idFecha;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<EncuentroDTO> getEncuentros() {
		return encuentros;
	}

	public void setEncuentros(List<EncuentroDTO> encuentros) {
		this.encuentros = encuentros;
	}
	
	
	
}
