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
import gui.Gui;
import gui.PanelPersonalizado;
import gui.PopupConfirmacion;
import gui.PopupError;

public class PanelVerCompetenciaConMensajes extends JPanel {

	private static final long serialVersionUID = 1L;
	private App padre;
	private PanelVerCompetencia panelinterno;
	private JLayeredPane panelcapas;
	private int idCompetencia;


	PopupConfirmacion fixturepopup = new PopupConfirmacion();
	PopupError error1 = new PopupError();

	public PanelVerCompetenciaConMensajes(App padre, int idCompetencia) {
		this.idCompetencia = idCompetencia;
		this.setPreferredSize(new Dimension(1200, 800));
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

	
		colocarPopup(error1, panelinterno.iconolapiz);
		colocarPopup(fixturepopup, panelinterno.botongenerarfixture);
//		fixturepopup.setVisible(true);

		
		this.add(panelcapas);

	}

	private void crearPanelInterno() {
		panelinterno = new PanelVerCompetencia(padre,idCompetencia);
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
	
	public void colocarPopup(JPanel p,JComponent c) {
		
		c.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				super.componentMoved(e);
				Dimension popupSize = p.getPreferredSize();
				Gui.imprimir(c.toString());
				Gui.imprimir(c.getLocation().toString());
				Point point = SwingUtilities.convertPoint(c, c.getX(), c.getY(), panelcapas);
				Gui.imprimir(point.toString());
				point.setLocation(point.getX()+20, point.getY()-popupSize.height/2 +10);
				Gui.imprimir(point.toString());
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
				
				
				c.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						p.setVisible(true);
					}
				});
				
				
			}
		});
		


		
	}


}
