package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;


public class MyHomeButton extends JButton {

	private static final long serialVersionUID = 1L;

	public MyHomeButton(String mensaje, String filename) {
		this.setPreferredSize(new Dimension(200,200));
		this.setMinimumSize(new Dimension(200,200));
		this.setText(mensaje);
		this.setIcon(Gui.emoji(filename, 64,64,false));
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		this.setFocusable(false);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setIconTextGap(20);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
	}
	
}
