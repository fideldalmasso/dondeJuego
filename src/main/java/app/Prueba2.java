package app;

import daos.UsuarioDAO;
import dominio.Usuario;

public class Prueba2 {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		u.setId(76);
		UsuarioDAO ud= new UsuarioDAO();
		ud.update(u);

	}

}
