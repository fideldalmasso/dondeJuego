package gestores;

import daos.LugarRealizacionDao;
import dominio.*;

public class GestorLugarRealizacion {
	private LugarRealizacionDao lrd;
	public GestorLugarRealizacion() {
		lrd = new LugarRealizacionDao();
	}
	public LugarRealizacion getLugarRealizacion(Integer id) {
		return this.lrd.getLugarRealizacion(id);
	}
}
