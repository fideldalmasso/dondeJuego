package gestores;

import java.util.List;

import daos.DeporteDAO;
import dominio.Deporte;

public class GestorDeporte {
	DeporteDAO dd;
	
	public GestorDeporte() {
		this.dd = new DeporteDAO(); 
	}
	
	public Deporte crearDeporte(String nombre) {
		Deporte deporte = new Deporte(nombre);
		dd.save(deporte);
		return deporte;
	}
	
	public List<Deporte> getAllDeportes(){
		return dd.getAll();
	}
	
	public Deporte get(Integer id) {
		return dd.get(id);
	}
	
	public void save(Deporte deporte) {
		dd.save(deporte);
	}
	
}
