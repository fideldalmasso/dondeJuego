package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Stroke;

import javax.swing.border.EmptyBorder;

public class PopupConfirmacionIzquierda extends PopupConfirmacion {

	public PopupConfirmacionIzquierda() {
		super();
		this.setBorder(new EmptyBorder(10,20,10,30));
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
//	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g.create();
	        Insets insets = getInsets();
	        int x = 0;
	        int y = 0;
	        int width = getWidth();
	        int height = getHeight();
	        Polygon bubble = new Polygon();
	        
//	      bubble.addPoint(x + insets.left - 15, y+1);
//	      bubble.addPoint(x + width-1, y+1);
//	      bubble.addPoint(x + width-1, y+height-1);
//	      bubble.addPoint(x + insets.left - 15, y+height-1);
//	      bubble.addPoint(x + insets.left - 15, y+height * 2/3);
//	      bubble.addPoint(x, y+height/ 2);
//	      bubble.addPoint(x + insets.left - 15, y+height /3);
//	      
	        
	        
	        bubble.addPoint(x+1, y+1);
	        bubble.addPoint(x + width - insets.right + 15, y+1);
	        bubble.addPoint(x + width - insets.right + 15, y + height / 3);
	        bubble.addPoint(x + width, y + height / 2);
	        bubble.addPoint(x + width - insets.right + 15, y + height * 2 / 3);
	        bubble.addPoint(x + width - insets.right + 15, y + height -1);
	        bubble.addPoint(x+1, y + height -1);

	      
	        g2d.setColor(getBackground());
	        g2d.fill(bubble);
	        g2d.setColor(Color.BLACK);
	        Stroke s = new BasicStroke(2);
	        g2d.setStroke(s);
	        g2d.draw(bubble);
	        g2d.dispose();
	    }
	
	
}
