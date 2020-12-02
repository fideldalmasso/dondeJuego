package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mensaje2<T> {
	
	public enum Type{ERROR,SUCCESS,CANCEL};
	
	private Map<T,String> mensaje;
	
	public Mensaje2() {
		this.mensaje = new HashMap<T,String>();
	}
	public Map<T,String> getMensaje(){
		return this.mensaje;
	}
	
	public void put(T index, String text) {
		this.mensaje.put(index, text);
	}
	
}
