package gestores;

import daos.UsuarioDAO;
import dominio.Usuario;

public class GestorUsuario {
	private UsuarioDAO ud;
	
	public GestorUsuario() {
		this.ud = new UsuarioDAO();
	}
	
	void save(Usuario usr) {
		ud.save(usr);
	}
	void update(Usuario usr) {
		ud.update(usr);
	}
}
