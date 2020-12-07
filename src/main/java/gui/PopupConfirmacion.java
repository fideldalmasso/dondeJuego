package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//https://stackoverflow.com/questions/35190710/paintcomponent-is-drawing-on-other-components

public class PopupConfirmacion extends JPanel {
	private static final long serialVersionUID = 1L;

	public JButton botonaceptar;
	
	public PopupConfirmacion() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150,90));
		JLabel texto = new JLabel("¿Estás seguro?");
		this.setBorder(new EmptyBorder(10,30,10,20));
		this.setOpaque(false);
		this.setBackground(Color.decode("#fff48f"));
		this.setVisible(false);
		
		texto.setAlignmentX(CENTER_ALIGNMENT);
		botonaceptar = new JButton("Si");
		botonaceptar.setAlignmentX(CENTER_ALIGNMENT);
		this.add(texto);
		this.add(Box.createRigidArea(new Dimension(10, 10)));
		this.add(botonaceptar);
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

