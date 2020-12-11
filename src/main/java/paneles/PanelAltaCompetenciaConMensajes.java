package paneles;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import app.App;
import gui.Gui;
import gui.MyError;
import gui.PopupConfirmacion;
import gui.PopupConfirmacionIzquierda;
import gui.PopupError;
import gui.PopupExito;

public class PanelAltaCompetenciaConMensajes extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLayeredPane panelcapas;
	private PanelAltaCompetencia panelinterno;
	private App padre;
	
	

	
	public PanelAltaCompetenciaConMensajes(App padre) {
		this.setPreferredSize(new Dimension(1200, 800));
		this.setMinimumSize(new Dimension(1200, 800));
		this.setOpaque(false);
		this.padre = padre; 
	
		panelcapas = new JLayeredPane();
		panelcapas.setPreferredSize(new Dimension(1200, 800));
		panelcapas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gui.imprimir(e.getPoint().toString());
			}
		});
		
		
		this.crearPanelInterno();

		this.add(panelcapas);
		
	}
	
	
	public void colocarPopup(JPanel p,int x, int y) {
//		x-=15;
		y-=p.getPreferredSize().height/2;
		p.setBounds(x,y,p.getPreferredSize().width,p.getPreferredSize().height);
		panelcapas.setLayer(p, 1);
		panelcapas.add(p);
		
	}
	
	private void crearPanelInterno() {
		panelinterno = new PanelAltaCompetencia();
		panelcapas.setLayer(panelinterno, 0);
		panelcapas.add(panelinterno);
		panelinterno.cargar(padre,this);
		Dimension di = panelinterno.getPreferredSize();
		Dimension de = panelcapas.getPreferredSize();
		int x = (de.width-di.width)/2;
		int y = (de.height-di.height)/2;
		panelinterno.setBounds(x,y,di.width,di.height);
		
	}
	
	public void conectarError(MyError error, PopupError p) {
		error.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(error.isEnabled()) {
					p.setText(error.message);
					p.setVisible(true);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				p.setVisible(false);
			}
		});
	}
	
	private void conectarConfirmacion(JButton boton, JPanel popup) {
		boton.addActionListener(e->{
			popup.setVisible(true);
			
		});
		
	}
	
	
}
