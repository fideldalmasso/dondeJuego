package app;

import daos.LugarRealizacionDAO;
import daos.UsuarioDAO;
import dominio.Usuario;
import gestores.GestorLugarRealizacion;
import gui.Gui;

public class Prueba2 {

	public static void main(String[] args) {
		GestorLugarRealizacion lrd = new GestorLugarRealizacion();
		Gui.imprimir(lrd.getAllLugarRealizacion(81).get(0).getId().toString());
	}

}
