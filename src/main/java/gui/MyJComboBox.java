package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class MyJComboBox<E> extends JComboBox<E> {

	private static final long serialVersionUID = 1L;
	
	public void enableComponentOnlyWhenSelected(Object value, JComponent... component) {
		this.addActionListener(e->{
			for (int i = 0; i < component.length; i++) {
				component[i].setEnabled(this.getSelectedItem().equals(value));
			}
		});
	}
	
    public MyJComboBox(E[] items) {
        super( items);
        
    }
    
    

}
