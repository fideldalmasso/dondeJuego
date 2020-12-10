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
	PopupExito exitopopup = new PopupExito("Competencia añadida con éxito",300);
	
	
	PopupConfirmacion confirmacionaceptar = new PopupConfirmacion();
	PopupConfirmacionIzquierda confirmacioncancelar = new PopupConfirmacionIzquierda();
	
	
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


		this.colocarPopup(nombrepopup, 666,130);
		this.colocarPopup(nombrepopup, 666,130);
		this.colocarPopup(deportepopup, 666,166);
		this.colocarPopup(lugarpopup, 935,208);
		this.colocarPopup(modalidadpopup, 666,371);
		this.colocarPopup(puntuacionpopup, 666,412);
		this.colocarPopup(partidoganadopopup, 666,451);
		this.colocarPopup(empatepopup, 666,490);
		this.colocarPopup(presentarsepopup, 666,527);
		this.colocarPopup(maxsetspopup, 935,452);
		this.colocarPopup(abandonopopup, 935,491);
		this.colocarPopup(exitopopup,904,732);
//		exitopopup.setVisible(true);
		
		
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
		this.colocarPopup(confirmacionaceptar, 906, 732);
		
		confirmacionaceptar.acceptbutton.addActionListener(e->{
			confirmacioncancelar.setVisible(false);
			if(panelinterno.agregarCompetencia())
				exitopopup.setVisible(true);
			
		});
		
		panelinterno.botoncancelar.addActionListener(e->{
			confirmacioncancelar.setVisible(true);
			confirmacionaceptar.setVisible(false);
		});
		
		this.colocarPopup(confirmacioncancelar, 706-confirmacioncancelar.getPreferredSize().width, 732);
		
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
