package paneles;

import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import app.App;

public class PanelPrueba extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLayeredPane panel1;
	private App padre;
	
	
	public PanelPrueba(App padre) {
		this.setPreferredSize(new Dimension(1000, 800));
		this.setOpaque(false);
		this.padre = padre; 

		panel1 = new JLayeredPane();
		panel1.setPreferredSize(new Dimension(1000, 800));



	}

}
