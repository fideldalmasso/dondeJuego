package dominio;

import java.util.ArrayList;
import java.util.List;

public class Mensaje {
	List<String> mensaje;
	
	public Mensaje() {
		this.mensaje = new ArrayList<String>();
	}
	public List<String> getMensaje(){
		return this.mensaje;
	}
}
