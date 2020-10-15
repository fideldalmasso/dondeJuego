package gui;


import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Gui {

	public static final Insets insetpredeterminado = new Insets(5,5,5,5);
	public static final Insets inseterror = new Insets(0,10,0,0);
	public static final Insets insetvacio = new Insets(0,0,0,0);

	private static void vacio(JPanel panel, int x, int y) {
		Gui.colocar(x,y,1,1,0,0,0,0,Gui.BOTH,Gui.CENTER,panel, new JLabel(" "));
	}
	
	public static void colocar(int column,
			int row, 
			int width, 
			int height, 
			double weightX, 
			double weightY, 
			int ipadx, 
			int ipady, 
			int fill, 
			int anchor,
			JPanel panel, JComponent comp){
		colocar2(column,row,width,height,weightX,weightY,ipadx,ipady,fill,anchor,insetpredeterminado,panel,comp);
	}


	public static void colocar2(
			int column,
			int row, 
			int width, 
			int height, 
			double weightX, 
			double weightY, 
			int ipadx, 
			int ipady, 
			int fill, 
			int anchor, 
			Insets inset, 
			JPanel panel, JComponent comp) {
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = column;      // column to start
		c1.gridy = row;         // row to start
		c1.gridwidth = width;   // number of cells wide
		c1.gridheight = height; // number of cells tall
		c1.weightx = weightX;   // when size is changed, grow in x direction
		c1.weighty = weightY;   // when size is changed, grow in y direction
		c1.ipadx = ipadx;       // espacio extra en x
		c1.ipady = ipady;		  // espacio extra en y
		c1.fill = fill;         // 0 NONE, 1 BOTH, 2 HORIZONTAL, 3 VERTICAL
		c1.anchor = anchor; 	  //10 CENTER
		c1.insets = inset;

		panel.add(comp,c1);  

	}



	public static final int RELATIVE = -1;

    
    public static final int REMAINDER = 0;

    
    public static final int NONE = 0;

    
    public static final int BOTH = 1;

    
    public static final int HORIZONTAL = 2;

    
    public static final int VERTICAL = 3;

    
    public static final int CENTER = 10;

    
    public static final int NORTH = 11;

    
    public static final int NORTHEAST = 12;

    
    public static final int EAST = 13;

    
    public static final int SOUTHEAST = 14;

    
    public static final int SOUTH = 15;

    
    public static final int SOUTHWEST = 16;

    
    public static final int WEST = 17;

    
    public static final int NORTHWEST = 18;

    
    public static final int PAGE_START = 19;

    
    public static final int PAGE_END = 20;

    
    public static final int LINE_START = 21;

    
    public static final int LINE_END = 22;

    
    public static final int FIRST_LINE_START = 23;

    
    public static final int FIRST_LINE_END = 24;

    
    public static final int LAST_LINE_START = 25;

    
    public static final int LAST_LINE_END = 26;

    
    public static final int BASELINE = 0x100;

    
    public static final int BASELINE_LEADING = 0x200;

    
    public static final int BASELINE_TRAILING = 0x300;

    
    public static final int ABOVE_BASELINE = 0x400;

    
    public static final int ABOVE_BASELINE_LEADING = 0x500;

    
    public static final int ABOVE_BASELINE_TRAILING = 0x600;

    
    public static final int BELOW_BASELINE = 0x700;

    
    public static final int BELOW_BASELINE_LEADING = 0x800;

    
    public static final int BELOW_BASELINE_TRAILING = 0x900;
	
	
	
}

