package dominio;

import java.util.ArrayList;
import java.util.List;

public class Mensaje {
	
	public enum Type{ERROR,SUCCESS,CANCEL};
	
	private List<String> mensaje;
	
	public Mensaje() {
		this.mensaje = new ArrayList<String>();
	}
	public List<String> getMensaje(){
		return this.mensaje;
	}
	
	public void add(String text) {
		this.mensaje.add(text);
	}
	
}
