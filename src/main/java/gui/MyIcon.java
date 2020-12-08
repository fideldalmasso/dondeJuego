package gui;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyIcon extends JLabel {

	private static final long serialVersionUID = 1L;	
	public ImageIcon icon;
	public ImageIcon emptyIcon;
	
	
	
	
	public MyIcon(String file, int width, int height, Boolean isAnimated) {
		this(file,width,height,true,true,isAnimated);
	}
	
	public MyIcon(String file, int width, int height, Boolean isEnabled, Boolean isVisible, Boolean isAnimated) {
		super();
		this.icon = Gui.emoji(file,width,height,isAnimated);
		this.emptyIcon = Gui.emoji("icon/empty.png", width, height, false);
		this.setIcon(icon);
		this.setEnabled(isEnabled);
		this.setVisible(isVisible);
		this.setPreferredSize(new Dimension(width,height));
		this.setMaximumSize(new Dimension(width,height));
		this.setMinimumSize(new Dimension(width,height));
	}
	
	
	public void showError(String toolTipText) {
		this.setEnabled(true);
		this.setToolTipText(toolTipText);
	}
	
	
	@Override
	public void setEnabled(boolean arg0) {
		super.setEnabled(arg0);
		if(!arg0)
			this.removeToolTip();
	}
	
	public void removeToolTip(){
		this.setToolTipText(null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		if(aFlag) 
			this.setIcon(icon);
		else
			this.setIcon(emptyIcon);
	}
	
	
}
