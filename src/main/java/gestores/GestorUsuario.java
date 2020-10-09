package gestores;

import daos.UsuarioDAO;

public class GestorUsuario {
	void guardar () {
		UsuarioDAO ud = new UsuarioDAO();
		ud.saveUsuario(new GestorAutenticacion().getUsuario());
	}
}
