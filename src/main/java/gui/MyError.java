package gui;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyError extends JLabel {

	private static final long serialVersionUID = 1L;

	public MyError() {
		super();
		this.setIcon(PanelPersonalizado.emoji("icon/error2.png",24,24));
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(24,24));
	}
	
	public void show2(Boolean b) {
		if(!b)
			this.setIcon(PanelPersonalizado.emoji("icon/empty.png",24,24));
		else
			this.setIcon(PanelPersonalizado.emoji("icon/error2.png",24,24));
	}
	
	public MyError(String mensaje) {
		this();
		this.setToolTipText(mensaje);
	}
	
}
