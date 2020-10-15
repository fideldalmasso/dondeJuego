package gui;

import javax.swing.JComboBox;
import javax.swing.JComponent;

public class MyJComboBox extends JComboBox<String> {

	private static final long serialVersionUID = 1L;
	
	public void enableComponentOnlyWhenSelected(Object value, JComponent... component) {
		this.addActionListener(e->{
			for (int i = 0; i < component.length; i++) {
				component[i].setEnabled(this.getSelectedItem().equals(value));
			}
		});
	}

	
    public MyJComboBox(String[] items) {
        super(items);
        if(this.getItemCount()>0)
        	this.setSelectedIndex(0);
        
    }
    
    public MyJComboBox() {
    	super();
    }
    
    @Override
    public String getSelectedItem() {
    	return (String)super.getSelectedItem();
    }
    

}
