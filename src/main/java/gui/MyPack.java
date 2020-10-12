package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyPack<T>  {

	private JLabel label;
	private T component;
	private MyError error;
	
	private void colocarLabel(JPanel temp) {
		Gui.colocar2(0,0,1,1,1,1,0,0,Gui.BOTH,Gui.NORTHWEST,Gui.insetvacio,temp,this.label);
	}
	private void colocarComponent(JPanel temp) {
		Gui.colocar2(1,0,1,1,1,1,0,0,Gui.BOTH,Gui.NORTHWEST,Gui.insetvacio,temp,(JComponent)this.component);
	}
	private void colocarError(JPanel temp) {
		Gui.colocar2(2,0,1,1,0,0,0,0,Gui.NONE,Gui.NORTHEAST,Gui.inseterror,temp,this.error);
	}
	
	
	public MyPack(String label) {
		super();
		this.label= new JLabel(label);
		this.error=new MyError();
		
	}
	
	public MyPack(String label, T component) {
		this(label);
		this.component=component;
//		this.setLayout(new GridBagLayout());
//		Gui.colocar2(0,0,1,1,1,1,0,0,Gui.BOTH,Gui.NORTHWEST,Gui.insetvacio,this,this.label);
//		Gui.colocar2(1,0,1,1,1,1,0,0,Gui.BOTH,Gui.NORTHWEST,Gui.insetvacio,this,this.component);
//		Gui.colocar2(2,0,1,1,0,0,0,0,Gui.NONE,Gui.NORTHEAST,Gui.inseterror,this,this.error);
//		this.colocarLabel(this);
//		this.colocarComponent(this);
//		this.colocarError(this);
	}
	
	public JPanel semi1() { // jlabel + component
		JPanel temp = new JPanel(new GridBagLayout());
		this.colocarLabel(temp);
		this.colocarComponent(temp);
		return temp;
	}
	public JPanel semi2() { // component + error
		JPanel temp = new JPanel(new GridBagLayout());
		this.colocarComponent(temp);
		this.colocarError(temp);
		return temp;
	}

	
	public JPanel full() { // jlabel + component + error
		JPanel temp = new JPanel(new GridBagLayout());
		this.colocarLabel(temp);		
//		this.colocarComponent(temp);
		Gui.colocar2(1,0,1,1,0,0,0,0,Gui.NONE,Gui.NORTHEAST,Gui.insetvacio,temp,(JComponent)this.component);
		this.colocarError(temp);
		return temp;	
	}
	
//	@Override
	public void setEnabled(boolean arg0) {
//		super.setEnabled(arg0);
		this.label.setEnabled(arg0);
		((JComponent)this.component).setEnabled(arg0);
//		this.error.setEnabled(arg0);
		this.error.setVisible(arg0);
	}

	public JLabel label() {
		return label;
	}

	public void setComponent(T component) {
		this.component=component;
	}
	
	public T component() {
		if(component==null)
			System.out.println("Te olvidaste de inicializar el componente \""+this.label.getText()+"\"");
		return component;
	}

	public MyError error() {
		return error;
	}
	
	public void showError(String toolTipText) {
		this.error.showError(toolTipText);
	}
	
}
