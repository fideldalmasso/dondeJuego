package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelFondo extends JPanel {
	
	
	public PanelFondo() {
		super();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		
		
	}

	public PanelFondo(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PanelFondo(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public PanelFondo(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		//http://bg.siteorigin.com/
		//https://tips4java.wordpress.com/2008/10/12/background-panel/
		super.paintComponent(g);
		Image imagen = new ImageIcon("icon/tile.png").getImage();

		Dimension d = this.getSize();
		int width = imagen.getWidth( null );
		int height = imagen.getHeight( null );

		for (int x = 0; x < d.width; x += width)
		{
			for (int y = 0; y < d.height; y += height)
			{
				g.drawImage( imagen, x, y, null, null );
			}
		}
	}
	
	
}
