package gestores;

import dominio.Competencia;
import dominio.Mensaje;
import dominio.ModalidadEliminatoriaDoble;
import dominio.ModalidadEliminatoriaSimple;

public class GestorFixture {
	
	Mensaje generarFixture(Integer id) {
		GestorCompetencia gc = new GestorCompetencia();
		Competencia c =  gc.getCompetencia(id);
		
		Mensaje mensaje = new Mensaje();
		if (c.getModalidad() instanceof ModalidadEliminatoriaSimple) {
			mensaje.add("Caso de uso no implementado");
			mensaje.setAccion(0);
		}else if(c.getModalidad() instanceof ModalidadEliminatoriaDoble) {
			mensaje.add("Caso de uso no implementado");
			mensaje.setAccion(0);
		}else {
			mensaje.add("¿Desea generar el fixture nuevamente?");
			mensaje.setAccion(1);
		}
		
		return mensaje;
	}
}