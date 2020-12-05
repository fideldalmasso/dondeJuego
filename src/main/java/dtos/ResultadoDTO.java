package dtos;

public abstract class ResultadoDTO {

	protected Integer idResultado;

	public Integer getIdResultado() {
		return idResultado;
	}
	public void setIdResultado(Integer idResultado) {
		this.idResultado = idResultado;
	}
	public ResultadoDTO(Integer idResultado) {
		super();
		this.idResultado = idResultado;
	}
	public ResultadoDTO() {
		super();
	}
	
}
