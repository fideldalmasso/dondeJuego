package gestores;

import java.sql.Timestamp;

import dominio.*;
import dtos.*;

public class GestorResultado {

	public ResultadoFinal crearResultado(ResultadoFinalDTO rdto) {
		return new ResultadoFinal(new Timestamp(System.currentTimeMillis()),rdto.getEmpate(),rdto.getGanaA(),rdto.getGanaB());
	}
	public ResultadoPuntuacion crearResulado(ResultadoPuntuacionDTO rdto) {
		return new ResultadoPuntuacion(new Timestamp(System.currentTimeMillis()), rdto.getPuntajeFinalA(), rdto.getPuntajeFinalB());
	}
	public ResultadoSets crearResultado(ResultadoSetsDTO rdto) {
		return new ResultadoSets(new Timestamp(System.currentTimeMillis()), rdto.getSets());
	}
}
