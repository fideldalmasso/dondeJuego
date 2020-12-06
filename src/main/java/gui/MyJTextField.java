package gui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class MyJTextField extends JTextField {

	private static final long serialVersionUID = 1L;
	
	private String hint;
	private Boolean changed=false;

	
	@Override
	public String getText() {
		String text = super.getText();
		
		return changed?text:"";
	}
	
	public MyJTextField(String text) {
		super(text);
		this.hint=text;
		this.setText(hint);
		
		
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
				if(!changed) {
					setText(hint);
				}
			}
		});
		
	}

	public Boolean hasChanged() {
		return changed;
	}
	

	
	//https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
	public void addChangeListener(ChangeListener changeListener) {
//	    Objects.requireNonNull(this);
//	    Objects.requireNonNull(changeListener);
	    DocumentListener dl = new DocumentListener() {
	        private int lastChange = 0, lastNotifiedChange = 0;

	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            changedUpdate(e);
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            changedUpdate(e);
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            lastChange++;
	            SwingUtilities.invokeLater(() -> {
	                if (lastNotifiedChange != lastChange) {
	                    lastNotifiedChange = lastChange;
	                    changeListener.stateChanged(new ChangeEvent(this));
	                }
	            });
	        }
	    };
	    this.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
	        Document d1 = (Document)e.getOldValue();
	        Document d2 = (Document)e.getNewValue();
	        if (d1 != null) d1.removeDocumentListener(dl);
	        if (d2 != null) d2.addDocumentListener(dl);
	        dl.changedUpdate(null);
	    });
	    Document d = this.getDocument();
	    if (d != null) d.addDocumentListener(dl);
	}
	
	
	
}
