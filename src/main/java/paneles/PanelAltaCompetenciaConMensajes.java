package paneles;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.App;
import gui.Gui;
import gui.MyError;
import gui.MyPack;
import gui.PanelPersonalizado;
import gui.PopupConfirmacion;
import gui.PopupConfirmacionIzquierda;
import gui.PopupError;
import guiejemplos.BubbleLabelRight;

public class PanelAltaCompetenciaConMensajes extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLayeredPane panelcapas;
	private PanelAltaCompetencia panelinterno;
	private App padre;
	
	
	PopupError nombrepopup = new PopupError();
	PopupError deportepopup = new PopupError();
	PopupError lugarpopup = new PopupError();
	PopupError modalidadpopup = new PopupError();
	PopupError puntuacionpopup = new PopupError();
	PopupError partidoganadopopup = new PopupError();
	PopupError empatepopup = new PopupError();
	PopupError presentarsepopup = new PopupError();
	PopupError maxsetspopup = new PopupError();
	PopupError abandonopopup = new PopupError();
	
	PopupConfirmacion confirmacionaceptar = new PopupConfirmacion();
	PopupConfirmacionIzquierda confirmacioncancelar = new PopupConfirmacionIzquierda();
	
	
	public PanelAltaCompetenciaConMensajes(App padre) {
		this.setPreferredSize(new Dimension(1000, 800));
		this.setOpaque(false);
		this.padre = padre; 
	
		panelcapas = new JLayeredPane();
		panelcapas.setPreferredSize(new Dimension(1000, 800));
		panelcapas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gui.imprimir(e.getPoint().toString());
			}
		});
		
		
		this.crearPanelInterno();


		this.colocarPopup(nombrepopup, 570,130);
		this.colocarPopup(nombrepopup, 571,130);
		this.colocarPopup(deportepopup, 573,166);
		this.colocarPopup(lugarpopup, 841,208);
		this.colocarPopup(modalidadpopup, 570,371);
		this.colocarPopup(puntuacionpopup, 570,412);
		this.colocarPopup(partidoganadopopup, 570,451);
		this.colocarPopup(empatepopup, 568,490);
		this.colocarPopup(presentarsepopup, 569,527);
		this.colocarPopup(maxsetspopup, 841,452);
		this.colocarPopup(abandonopopup, 841,491);

		this.conectarError(panelinterno.nombre.error(), nombrepopup);
		this.conectarError(panelinterno.deporte.error(), deportepopup);
		this.conectarError(panelinterno.lugar.error(), lugarpopup);
		this.conectarError(panelinterno.modalidad.error(), modalidadpopup);
		this.conectarError(panelinterno.formapuntuacion.error(), puntuacionpopup);
		this.conectarError(panelinterno.puntosporpartidoganado.error(), partidoganadopopup);
		this.conectarError(panelinterno.puntosporempate.error(), empatepopup);
		this.conectarError(panelinterno.puntosporpresentarse.error(), presentarsepopup);
		this.conectarError(panelinterno.cantidadmaximadesets.error(), maxsetspopup);
		this.conectarError(panelinterno.puntosporabandono.error(), abandonopopup);

		
		panelinterno.botonaceptar.addActionListener(e->{
			confirmacionaceptar.setVisible(true);
			confirmacioncancelar.setVisible(false);
		});
		this.colocarPopup(confirmacionaceptar, 805, 732);
		confirmacionaceptar.acceptbutton.addActionListener(e->{
			confirmacioncancelar.setVisible(false);
			panelinterno.agregarCompetencia();
			
		});
		
		panelinterno.botoncancelar.addActionListener(e->{
			confirmacioncancelar.setVisible(true);
			confirmacionaceptar.setVisible(false);
		});
		this.colocarPopup(confirmacioncancelar, 604-confirmacioncancelar.getPreferredSize().width, 732);
		confirmacioncancelar.acceptbutton.addActionListener(e->{
			confirmacioncancelar.setVisible(false);
			padre.volverAtras();
		});


		this.add(panelcapas);
		
	}
	
	
	public void colocarPopup(JPanel p,int x, int y) {
//		x-=15;
		y-=p.getPreferredSize().height/2;
		p.setBounds(x,y,p.getPreferredSize().width,p.getPreferredSize().height);
		panelcapas.add(p,0);
		
	}
	
	private void crearPanelInterno() {
		panelinterno = new PanelAltaCompetencia(padre);
		Dimension di = panelinterno.getPreferredSize();
		Dimension de = panelcapas.getPreferredSize();
		int x = (de.width-di.width)/2;
		int y = (de.height-di.height)/2;
		panelinterno.setBounds(x,y,di.width,di.height);
		panelcapas.add(panelinterno,1);
		
	}
	
	private void conectarError(MyError error, PopupError p) {
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
