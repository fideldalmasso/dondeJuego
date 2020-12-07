package gui;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyError extends JLabel {

	private static final long serialVersionUID = 1L;

	
	public String message;
	public Boolean cargando = false;
	
	public MyError() {
		this(false);

	}
	
	public MyError(Boolean cargando) {
		super();
		this.message = "";
		this.cargando = cargando;
		if(cargando)
			this.setIcon(PanelPersonalizado.emoji("icon/loading3.gif",24,24));
		else
			this.setIcon(PanelPersonalizado.emoji("icon/error2.png",24,24));
		
		this.setEnabled(false);
		this.setPreferredSize(new Dimension(24,24));
		
		
	}
	
	
	public void showError(String toolTipText) {
		this.setEnabled(true);
		//this.setToolTipText(toolTipText);
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
		if(!aFlag) {
			if(cargando)
				this.setIcon(PanelPersonalizado.emoji("icon/loading3.gif",24,24));
			else
				this.setIcon(PanelPersonalizado.emoji("icon/empty.png",24,24));
		}
		else
			this.setIcon(PanelPersonalizado.emoji("icon/error2.png",24,24));
	}
	
	public MyError(String mensaje) {
		this();
		this.setToolTipText(mensaje);
	}
	
}
