package gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MyIcon2 extends JButton {

	private static final long serialVersionUID = 1L;	
	public ImageIcon icon;
	public ImageIcon emptyIcon;
	
	
	
	
	public MyIcon2(String file, int width, int height, Boolean isAnimated) {
		this(file,width,height,true,true,isAnimated);
	}
	
	public MyIcon2(String file, int width, int height, Boolean isEnabled, Boolean isVisible, Boolean isAnimated) {
		super();
		this.icon = Gui.emoji(file,width,height,isAnimated);
		this.emptyIcon = Gui.emoji("icon/empty.png", width, height, false);
		this.setIcon(icon);
		this.setEnabled(isEnabled);
		this.setVisible(isVisible);
		this.setPreferredSize(new Dimension(width,height));
		this.setMaximumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	
	@Override
	public void setVisible(boolean aFlag) {
		if(aFlag) 
			this.setIcon(icon);
		else
			this.setIcon(emptyIcon);
	}
	
	
}
