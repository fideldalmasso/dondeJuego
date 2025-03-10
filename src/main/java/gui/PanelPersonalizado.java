package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public abstract class PanelPersonalizado extends JPanel{

	private static final long serialVersionUID = 1L;

	public static final Insets insetpredeterminado = new Insets(5,5,5,5);
	public static final Insets inseterror = new Insets(0,10,0,0);
	public static final Insets insetvacio = new Insets(0,0,0,0);
	protected  static final String fileFondo = "icon/tile.png";
	
	public  static ImageIcon errorIcono = emoji("icon/error2.png",24,24);
	public JLabel terror() {
		return new JLabel(errorIcono);
	}

	public static JPanel crearComponenteConErrorYLabel(JComponent label, JComponent componente, JLabel error) {
		JPanel panel01 = new JPanel(new GridBagLayout());
		
		colocar2(0,0,1,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,insetvacio,panel01,label);
		colocar2(2,0,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,insetvacio,panel01,componente);

		colocar2(3,0,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,inseterror,panel01,error);
		
		return panel01;

	}
	
	
	public static JPanel crearComponenteConError(JComponent componente, JLabel error) {
		JPanel panel01 = new JPanel(new GridBagLayout());
		
		colocar2(0,0,1,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.NORTHWEST,insetvacio,panel01,componente);

		colocar2(1,0,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHEAST,inseterror,panel01,error);
		
		return panel01;

	}


	

	public  PanelPersonalizado() {
		super();
		this.setBackground(Color.decode("#eeeeee"));
		Border borde1 = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#33658a"));
		Border borde2 = BorderFactory.createEmptyBorder(5,40,5,40);
		LineBorder borde3 = new LineBorder(Color.decode("#33658a"), 5, true);
		this.setBorder(new CompoundBorder(borde3,borde2));
		//this.fileFondo = "icon/fondo2.png";
	}

	//CREAR TITULO
	static public JLabel crearTitulo(String mensaje) {
		JLabel titulo = new JLabel(mensaje,SwingConstants.CENTER);

		titulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
		titulo.setForeground(Color.BLACK);
		return titulo;
	}

	public void setearFuente(JComponent[] lista) {
		for(JComponent c : lista){
			c.setForeground(Color.BLACK);
			c.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		}
	}


		//Este metodo dibuja la imagen de fondo
//		@Override
//		protected void paintComponent(Graphics g) {
//			//http://bg.siteorigin.com/
//			//https://tips4java.wordpress.com/2008/10/12/background-panel/
//			super.paintComponent(g);
//			Image imagen = new ImageIcon(fileFondo).getImage();
//	
//			Dimension d = this.getSize();
//			int width = imagen.getWidth( null );
//			int height = imagen.getHeight( null );
//	
//			for (int x = 0; x < d.width; x += width)
//			{
//				for (int y = 0; y < d.height; y += height)
//				{
//					g.drawImage( imagen, x, y, null, null );
//				}
//			}
//		}

	//CREAR FORMATTEDTEXTS-------------------------------------------------------------------------------------------------------------------------

	public static JPanel crearPanelInterno(String titulo) {
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		panel2.setOpaque(false);

		Border borde2 = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.decode("#33658a"));
		borde2 = BorderFactory.createTitledBorder(borde2, titulo, TitledBorder.LEFT, TitledBorder.TOP, new Font("Comic Sans MS", Font.BOLD, 20),  Color.decode("#33658a"));
		panel2.setBorder(borde2);
		return panel2;
	}

	public static JFormattedTextField crearCampoDinero() {

		NumberFormat format3 = NumberFormat.getNumberInstance(Locale.US);
		format3.setGroupingUsed(false);

		JFormattedTextField temp = new JFormattedTextField(
				new DefaultFormatterFactory(
						new NumberFormatter(NumberFormat.getCurrencyInstance(Locale.US)), 
						new NumberFormatter(NumberFormat.getCurrencyInstance(Locale.US)), 
						new NumberFormatter(format3)));

		temp.addPropertyChangeListener("value", e ->{
			if(temp.getValue() != null) 
				temp.setValue(((Number)temp.getValue()).doubleValue());
		});

		/*
		 * temp.addFocusListener(new FocusAdapter() { public void
		 * focusLost(java.awt.event.FocusEvent e) { if(temp.getValue() != null) {
		 * temp.firePropertyChange("value", 999.0, 999.0); //double valor =
		 * ((Number)temp.getValue()).doubleValue(); //temp.setValue(valor);
		 * 
		 * }else { temp.setValue(0.0); }
		 * 
		 * }; });
		 */

		return temp;

	}

	public static JFormattedTextField crearCampoDouble() {
		//https://stackoverflow.com/questions/27056539/how-to-add-only-double-values-in-jformattedtextfield
		NumberFormat format1 = DecimalFormat.getInstance(Locale.US);
		format1.setMinimumFractionDigits(2);
		format1.setMaximumFractionDigits(2);
		//		format1.setGroupingUsed(false);

		//format1.setRoundingMode(RoundingMode.HALF_UP);

		NumberFormat format3 = NumberFormat.getNumberInstance(Locale.US);
		format3.setGroupingUsed(false);

		JFormattedTextField temp = new JFormattedTextField(
				new DefaultFormatterFactory(
						new NumberFormatter(format1), 
						new NumberFormatter(format1), 
						new NumberFormatter(format3)));

		return temp;
	}

	public static  JFormattedTextField crearCampoFecha() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField temp = new JFormattedTextField(format);
		temp.setToolTipText("Formato de fecha: dd/MM/yyyy");
		return temp;
	}

	//CREAR POPUPS-------------------------------------------------------------------------------------------------------------------------

	static public void exitoPopUp(String text) {
		JOptionPane.showMessageDialog(null, text,"Éxito",JOptionPane.INFORMATION_MESSAGE,emoji("icon/success.png", 32,32));
	}

	static public void errorPopUp(String text) {
		JOptionPane.showMessageDialog(null, text,"Error",JOptionPane.ERROR_MESSAGE,PanelPersonalizado.emoji("icon/error.png", 32,32));
	}


	static public String ingresoPopUp(String mensaje) {
		return (String) JOptionPane.showInputDialog(null, mensaje, "Ingreso", JOptionPane.OK_CANCEL_OPTION, emoji("icon/pencil.png", 32,32), null, null);	 
	}


	static public String ingresoComboPopUp(String mensaje, String []lista) {
		return (String) JOptionPane.showInputDialog(null, mensaje, "Ingreso", JOptionPane.OK_CANCEL_OPTION, emoji("icon/pencil.png", 32,32), lista, lista[0]);
	}

	//este método retorna el índice seleccionado de la lista 
	static public Integer ingresoComboPopUpInt(String mensaje, String[] lista) {
		String valor = (String) JOptionPane.showInputDialog(null, mensaje, "Ingreso", JOptionPane.OK_CANCEL_OPTION, emoji("icon/pencil.png", 32,32), lista, lista[0]);
		if(valor == null)
			return -1;
		else {
			int i = 0;
			while(true) {
				if(lista[i].equals(valor))
					return i;
				else
					i++;	
			}
		}

	}


	static public int okCancelPopUp(String mensaje) {
		return JOptionPane.showOptionDialog(null, mensaje, "Eliminar",JOptionPane.OK_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE, PanelPersonalizado.emoji("icon/warning.png", 32,32), null, null);
	}

	static public String seleccionPopUp(String[] valores) {
		return (String) JOptionPane.showInputDialog(null, "Seleccione un valor de la lista", "Ingreso",JOptionPane.OK_CANCEL_OPTION, emoji("icon/pencil.png", 32,32), valores, null);
	}




	//CREAR BOTONES-------------------------------------------------------------------------------------------------------------------------

	static public JButton botonEliminar(String mensaje) {
		JButton boton = new JButton(mensaje,emoji("icon/trash.png", 24,24));
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		return boton;
	}

	static public JButton botonAgregar(String mensaje) {
		JButton boton = new JButton(mensaje,emoji("icon/save.png", 24,24));
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		return boton;
	}

	static public JButton botonEditar(String mensaje) {
		JButton boton = new JButton(mensaje,emoji("icon/pencil.png",24,24));
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		return boton;
	}

	static public JButton botonBusqueda(String mensaje) {
		JButton boton = new JButton(mensaje,emoji("icon/search.png",24,24));
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		return boton;
	}


	static public JButton botonLimpiar(String mensaje) {
		JButton boton = new JButton(mensaje,emoji("icon/broom.png",24,24));
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		return boton;
	}

	//USAR ESTE MÉTODO SOLO CON JPANEL QUE TENGAN GRIDBAGLAYOUT

	static public void colocar(int column,
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


		static public void colocar2(
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

		//CARGAR EMOJIS-------------------------------------------------------------------------------------------------------------------------



		static public ImageIcon emoji(String fileName, int width, int height) {
			Image imagen = new ImageIcon(fileName).getImage().getScaledInstance(width,height, Image.SCALE_REPLICATE);
			return new ImageIcon(imagen);
		}
		
		




	}
