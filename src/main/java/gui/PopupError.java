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
import java.awt.geom.Area;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//https://stackoverflow.com/questions/35190710/paintcomponent-is-drawing-on-other-components

public class PopupError extends JPanel {
	private static final long serialVersionUID = 1L;

	public MyIcon icon;
	public JLabel text;
	public JButton button;
	
	public void setWidth(int width) {
		Dimension d = this.getPreferredSize();
		
		this.setPreferredSize(new Dimension(width, d.height));
	}
	
	
	public PopupError() {
		super();
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(250,38));
//		this.setMinimumSize(new Dimension(100,38));
		this.setBorder(new EmptyBorder(10,25,10,10));
		this.setOpaque(false);
		this.setBackground(Color.decode("#e99998"));
		this.setVisible(false);

		this.icon = new MyIcon("icon/error4.png", 20, 20, false);
		this.text = new JLabel();
		this.text.setForeground(Color.WHITE);
		
		this.button = new JButton(Gui.emoji("icon/cerrar.png", 10, 10, false));
		this.button.setOpaque(false);
		this.button.setContentAreaFilled(false);
		this.button.setBorder(BorderFactory.createEmptyBorder());
		
		this.button.addActionListener(e->{
			this.setVisible(false);
		});
		
		Gui.colocar2(1 , 1, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, new Insets(0, 0, 0, 0), this, icon);
		Gui.colocar2(2 , 1, 1, 1, 1, 1, 0, 0, Gui.BOTH, Gui.WEST, new Insets(0, 10, 0, 0), this, text);
		Gui.colocar2(3 , 1, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.NORTHEAST, new Insets(0, 0, 0, 0), this, button);
		
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
        g2d.setColor(Color.WHITE);
        Stroke s = new BasicStroke(2);
        g2d.setStroke(s);
        g2d.draw(bubble);
        g2d.dispose();
    }

    public void setText(String text) {
    	this.text.setText(text);
    }
    
}

