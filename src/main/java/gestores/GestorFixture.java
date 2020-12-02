package gestores;

import java.util.List;

import dominio.Competencia;
import dominio.CompetenciaLugar;
import dominio.Encuentro;
import dominio.Fecha;
import dominio.Fixture;
import dominio.LugarRealizacion;
import dominio.Mensaje;
import dominio.ModalidadEliminatoriaDoble;
import dominio.ModalidadEliminatoriaSimple;
import dominio.Participante;
import enumerados.EstadoCompetencia;

public class GestorFixture {
	Competencia c;
	GestorCompetencia gc;
	
	Mensaje generarFixture(Integer id) {
		gc = new GestorCompetencia();
		c =  gc.getCompetencia(id);
		
		Mensaje mensaje = new Mensaje();
		if (c.getModalidad() instanceof ModalidadEliminatoriaSimple) {
			mensaje.add("Caso de uso no implementado.");
			mensaje.setAccion(0);
		}else if(c.getModalidad() instanceof ModalidadEliminatoriaDoble) {
			mensaje.add("Caso de uso no implementado.");
			mensaje.setAccion(0);
		}else {
			if(c.getEstado().equals(EstadoCompetencia.ENDISPUTA) 
			|| c.getEstado().equals(EstadoCompetencia.FINALIZADA)) {
				mensaje.add("No se pudo volver a crear el fixture.");
				mensaje.setAccion(0);
			}else {
				mensaje.add("¿Desea generar el fixture nuevamente?");
				mensaje.setAccion(1);
			}
		}
		
		return mensaje;
	}
	
	Mensaje crearFixture() {
		Mensaje mensaje = new Mensaje();
		List<Participante> ps = c.getParticipantes();
		List<CompetenciaLugar> cls = c.getLugares();
		Integer dt = 0;
		for(CompetenciaLugar cl : cls) dt += cl.getDisponibilidad();
		
		if(dt<ps.size()/2) {
			mensaje.add("Lugares de realizacion insuficientes.");
			mensaje.setAccion(0);
		}else {
			if(ps.size()%2==1) {
				ps.add(new Participante());
			}
			Fixture fixture = new Fixture();
			Integer tam = ps.size();
			for(int i=0;i<tam;i++) {
				Fecha fecha = new Fecha();
				for(int j=0; j<tam/2;j++) {
					if(ps.get(j).getEmail()!=null
					&& ps.get(tam-1-j).getEmail()!=null) {
						Encuentro encuentro = new Encuentro();
						encuentro.setParticipanteA(ps.get(j));
						encuentro.setParticipanteB(ps.get(tam-j-1));
						encuentro.setLugarRealizacion(l);
					}
				}
			}
		}
		
		return mensaje;
	}
}