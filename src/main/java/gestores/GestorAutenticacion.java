package gestores;

import java.util.ArrayList;

import dominio.*;
import enumerados.*;

public class GestorAutenticacion {
	public Usuario getUsuario() {
		Usuario usu= new Usuario();
		usu.setTipoDocumento(TipoDocumento.DNI);
		usu.setNumeroDocumento("1234567");
		usu.setApellido("De Prueba");
		usu.setNombre("Usuario");
		usu.setCompetencias(new ArrayList<Competencia>());
		usu.setContrasenia("abc");
		usu.setEmail("def@gmail.com");
		Pais arg= new Pais();
		arg.setNombre("Argentina");
		Provincia er = new Provincia();
		er.setNombre("Entre Rios");
		Localidad pna = new Localidad();
		pna.setNombre("Parana");
		arg.setProvincias(new ArrayList<Provincia>());
		arg.getProvincias().add(er);
		er.setPais(arg);
		er.setLocalidades(new ArrayList<Localidad>());
		er.getLocalidades().add(pna);
		pna.setProvincia(er);
		usu.setLocalidad(pna);
		usu.setRegistrado(true);
		usu.setRegistros(new ArrayList<RegistroSesion>());
		return usu;
	}
}
