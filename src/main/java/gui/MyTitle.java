package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyTitle extends JLabel {

	private static final long serialVersionUID = 1L;
	
	public MyTitle(String text) {
		super(text,SwingConstants.CENTER);
		this.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
		this.setForeground(Color.BLACK);
		
	}
	
}
