package gestores;

import java.util.List;

import daos.LugarRealizacionDAO;
import dominio.*;

public class GestorLugarRealizacion {
	private LugarRealizacionDAO lrd;
	public GestorLugarRealizacion() {
		lrd = new LugarRealizacionDAO();
	}
	public LugarRealizacion getLugarRealizacion(Integer id) {
		return this.lrd.getLugarRealizacion(id);
	}
	public List<LugarRealizacion> getAllLugarRealizacion(){
		return this.lrd.getAllLugarRealizacion();
	 }
}
