package gestores;

import daos.UsuarioDAO;

public class GestorUsuario {
	void guardar () {
		UsuarioDAO ud = new UsuarioDAO();
		ud.guardar(new GestorAutenticacion().getUsuario());
	}
}
