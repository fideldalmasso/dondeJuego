package dominio;

import java.util.ArrayList;
import java.util.List;

public class Mensaje {
	
	public enum Type{ERROR,SUCCESS,CANCEL};
	Integer accion;
	
	private List<String> mensaje;
	private String texto;
	
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Mensaje() {
		this.mensaje = new ArrayList<String>();
	}
	public List<String> getMensaje(){
		return this.mensaje;
	}
	
	public void add(String text) {
		this.mensaje.add(text);
	}
	
	public void setAccion(Integer accion) {
		this.accion=accion;
	}
	public Integer getAccion() {
		return accion;
	}
	
	
	
}
