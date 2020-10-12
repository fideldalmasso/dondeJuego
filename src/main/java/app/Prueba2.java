package app;

import daos.LugarRealizacionDAO;
import daos.UsuarioDAO;
import dominio.Usuario;
import gestores.GestorLugarRealizacion;

public class Prueba2 {

	public static void main(String[] args) {
		GestorLugarRealizacion lrd = new GestorLugarRealizacion();
		System.out.println(lrd.getAllLugarRealizacion(81).get(0).getId());
	}

}
