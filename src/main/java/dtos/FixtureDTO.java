package dtos;

import java.util.List;

public class FixtureDTO {
	private Integer idFixture;
	private List<FechaDTO> fechas;
	
	public FixtureDTO() {
		super();
	}

	public FixtureDTO(Integer idFixture, List<FechaDTO> fechas) {
		super();
		this.idFixture = idFixture;
		this.fechas = fechas;
	}

	public Integer getIdFixture() {
		return idFixture;
	}

	public void setIdFixture(Integer idFixture) {
		this.idFixture = idFixture;
	}

	public List<FechaDTO> getFechas() {
		return fechas;
	}

	public void setFechas(List<FechaDTO> fechas) {
		this.fechas = fechas;
	}

	
	
	
}
