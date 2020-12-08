package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//https://stackoverflow.com/questions/35190710/paintcomponent-is-drawing-on-other-components

public class PopupConfirmacion extends JPanel {
	private static final long serialVersionUID = 1L;

	public JButton acceptbutton;
	public JButton closebutton;
	
	public PopupConfirmacion() {
		super();
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(160,90));
		JLabel texto = new JLabel("¿Estás seguro?");
		this.setBorder(new EmptyBorder(10,30,10,20));
		this.setOpaque(false);
		this.setBackground(Color.decode("#fff48f"));
		this.setVisible(false);
	
		this.closebutton = new JButton(Gui.emoji("icon/cerrar_negro.png", 10, 10, false));
		this.closebutton.setOpaque(false);
		this.closebutton.setContentAreaFilled(false);
		this.closebutton.setBorder(BorderFactory.createEmptyBorder());
		
		this.closebutton.addActionListener(e->{
			this.setVisible(false);
		});
		

		
		
		
		acceptbutton = new JButton("Si");
		
		Gui.colocar2(1, 1, 1, 1, 0, 0, 0, 0, Gui.HORIZONTAL, Gui.NORTHWEST, new Insets(5, 0, 0, 0), this, texto);
		Gui.colocar2(2, 1, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.NORTHEAST, new Insets(0, 15, 0, 0), this, closebutton);
		Gui.colocar2(1, 2, 2, 1, 0, 0, 0, 0, Gui.NONE, Gui.CENTER, new Insets(10, 0, 0, 0), this, acceptbutton);
		
//		this.add(texto);
//		this.add(acceptbutton);
		
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Insets insets = getInsets();
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        Polygon bubble = new Polygon();
        
      bubble.addPoint(x + insets.left - 15, y+1);
      bubble.addPoint(x + width-1, y+1);
      bubble.addPoint(x + width-1, y+height-1);
      bubble.addPoint(x + insets.left - 15, y+height-1);
      bubble.addPoint(x + insets.left - 15, y+height * 2/3);
      bubble.addPoint(x, y+height/ 2);
      bubble.addPoint(x + insets.left - 15, y+height /3);
      
        
        
//        bubble.addPoint(x, y);
//        bubble.addPoint(x + width - insets.right + 10, y);
//        bubble.addPoint(x + width - insets.right + 10, y + height / 3);
//        bubble.addPoint(x + width, y + height / 2);
//        bubble.addPoint(x + width - insets.right + 10, y + height * 2 / 3);
//        bubble.addPoint(x + width - insets.right + 10, y + height -1);
//        bubble.addPoint(x, y + height -1);

      
        g2d.setColor(getBackground());
        g2d.fill(bubble);
        g2d.setColor(Color.BLACK);
        Stroke s = new BasicStroke(2);
        g2d.setStroke(s);
        g2d.draw(bubble);
        g2d.dispose();
    }

    
}

