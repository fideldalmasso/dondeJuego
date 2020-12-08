package gui;

import java.awt.Color;
import java.awt.Dimension;

public class PopupExito extends PopupError {

	public PopupExito(String text, int width) {
		super();
		this.setPreferredSize(new Dimension(width,50));
		this.setBackground(Color.decode("#92c47d"));
		this.icon = new MyIcon("icon/exito2.png", 20, 20, false);
		this.text.setText(text);
	}
	
	
}
