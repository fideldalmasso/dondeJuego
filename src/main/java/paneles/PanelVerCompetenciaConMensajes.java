package paneles;

import java.awt.Dimension;

import javax.swing.JPanel;

import app.App;
import gui.PanelPersonalizado;

public class PanelVerCompetenciaConMensajes extends JPanel {

	private static final long serialVersionUID = 1L;
	private App padre;
	private PanelVerCompetencia panelinterno;
	
	public PanelVerCompetenciaConMensajes(App padre, int idCompetencia) {
		this.padre = padre;
		panelinterno = new PanelVerCompetencia(padre);
		this.add(panelinterno);
		
	}
	
	
	
}
