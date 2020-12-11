package paneles;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.App;
import dominio.Mensaje;
import gestores.GestorFixture;
import gui.Gui;
import gui.PanelPersonalizado;
import gui.PopupConfirmacion;
import gui.PopupError;
import gui.PopupExito;

public class PanelAgregarParticipanteConMensajes extends JPanel {

	private static final long serialVersionUID = 1L;
	private App padre;
	private PanelAgregarParticipante panelinterno;
	private JLayeredPane panelcapas;
	private int idCompetencia;

	String nombreCompetencia;

	public PanelAgregarParticipanteConMensajes(App padre, int idCompetencia, String nombreCompetencia) {
		this.idCompetencia = idCompetencia;
		this.nombreCompetencia= nombreCompetencia;
		this.setPreferredSize(new Dimension(1100, 800));
		this.setMinimumSize(new Dimension(1100, 800));
		this.setOpaque(false);
		this.padre = padre;
		this.setFocusable(true);

		panelcapas = new JLayeredPane();
		panelcapas.setLayout(null);
		panelcapas.setPreferredSize(new Dimension(1200, 800));
		panelcapas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gui.imprimir(e.getPoint().toString());
			}
		});


		this.crearPanelInterno();
		panelinterno.setFocusable(true);
		panelcapas.setFocusable(true);

		this.add(panelcapas);

	}

	private void crearPanelInterno() {
		panelinterno = new PanelAgregarParticipante(padre,idCompetencia,nombreCompetencia,this);
		Dimension di = panelinterno.getPreferredSize();
		Dimension de = panelcapas.getPreferredSize();
		int x = (de.width-di.width)/2;
		int y = (de.height-di.height)/2;
		panelinterno.setBounds(x,y,di.width,di.height);
		panelcapas.setLayer(panelinterno, 0);
		panelcapas.add(panelinterno);

	}


	public void colocarPopup(JPanel p, int x, int y) {
		Dimension popupSize = p.getPreferredSize();
		p.setBounds(x, y, popupSize.width, popupSize.height);
	}

	public void colocarPopup(JPanel p,JComponent c, boolean activarConClic) {

		c.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				super.componentMoved(e);
//				Gui.DEBUG=false;
				Dimension popupSize = p.getPreferredSize();
				Point point = SwingUtilities.convertPoint(c, c.getX(), c.getY(), panelcapas);
				point.setLocation(point.getX()+20, point.getY()-popupSize.height/2 +10);
				p.setBounds(new Rectangle(point, popupSize));
				panelcapas.setLayer(p, 1);
				panelcapas.add(p);

				//				p.setVisible(true);
				panelcapas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						if(!p.getVisibleRect().contains(e.getPoint()))
							p.setVisible(false);
					}
				});

				if(activarConClic) {
					c.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							p.setVisible(true);
						}
					});
				}
//				Gui.DEBUG=true;
			}
		});




	}


}
