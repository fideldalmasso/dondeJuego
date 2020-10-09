package gui;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Error extends JLabel {

	private static final long serialVersionUID = 1L;

	public Error() {
		super();
		this.setIcon(PanelPersonalizado.emoji("icon/error2.png",24,24));
	}
	
	public Error(String mensaje) {
		this();
		this.setToolTipText(mensaje);
	}
	
}
