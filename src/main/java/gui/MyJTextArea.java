package gui;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class MyJTextArea extends JTextArea {

	private static final long serialVersionUID = 1L;
	
	String hint;
	Boolean changed=false;

	public MyJTextArea(String text) {
		super(text);
		this.hint=text;
		this.setText(hint);
		this.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				changed=true;
			}
		});
		
		this.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				super.focusGained(e);
				if(!changed)
					setText("");
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				if(getText()==null || getText().length()==0)
					changed=false;
				if(!changed) {
					setText(hint);
				}
			}
		});
		
	}

	public Boolean hasChanged() {
		return changed;
	}
	

}
