package gestores;

import java.util.ArrayList;

import daos.UsuarioDAO;
import dominio.*;
import enumerados.*;

public class GestorAutenticacion {
	private static Usuario usuarioAutenticado;
	
	public void login(String email, String contrasenia) {
		UsuarioDAO ud = new UsuarioDAO();
		usuarioAutenticado = ud.get(email, contrasenia);
	}
	
	public Usuario getUsuario() {
		return usuarioAutenticado;
	}
}
