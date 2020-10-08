package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelAltaCompetencia extends PanelPersonalizado {

	private static final long serialVersionUID = 1L;
	private JLabel titulo = crearTitulo("Crear competencia"); 
	private JLabel tnombre = new JLabel("Nombre",SwingConstants.LEFT);
	private JLabel tdeporte = new JLabel("Deporte",SwingConstants.LEFT);
	private JLabel tlugar = new JLabel("Lugar(Disponibilidad)",SwingConstants.LEFT);
	private JLabel tmodalidad = new JLabel("Modalidad",SwingConstants.LEFT);
	private JLabel tformadepuntuacion = new JLabel("Forma de puntuación",SwingConstants.LEFT);
	private JLabel tpuntosporpartidoganado = new JLabel("Puntos por partido ganado",SwingConstants.LEFT);
	private JLabel tcantidaddesets= new JLabel("Cantidad de sets",SwingConstants.LEFT);
	private JLabel tempatepermitido = new JLabel("Empate permitido",SwingConstants.LEFT);
	private JLabel tpuntosporempate = new JLabel("Puntos por empate",SwingConstants.LEFT);
	private JLabel tpuntosporabandono = new JLabel("Puntos por abandono",SwingConstants.LEFT);
	private JLabel tpuntosporpresentarse = new JLabel("Puntos por presentarse",SwingConstants.LEFT);
	private JLabel treglamento = new JLabel("Reglamento",SwingConstants.LEFT);
	
	
	private JTextField nombre = new JTextField("Ingrese uno...");
	private JComboBox<String> combodeporte = new JComboBox<String>();
	private JTable tablalugares = new JTable();
	private JComboBox<String> combomodalidad = new JComboBox<String>();
	private JComboBox<String> comboformapuntuacion = new JComboBox<String>();
	private List<JSpinner> listaspinners = new ArrayList<JSpinner>(Collections.nCopies(5, new JSpinner()));
	private JTextArea reglamento= new JTextArea("Ingrese uno...");
	
	private JPanel panel01;
	
	
	public PanelAltaCompetencia() {
		this.setPreferredSize(new Dimension(699, 734));
//		this.setBackground(new Color(250, 216, 214));
		this.setLayout(new GridBagLayout());
		
		{	 
			titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		{
			panel01 = new JPanel(new GridBagLayout());
			colocar(0,0,1,1,1,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,0,panel01, nombre);
			JLabel labelError= new JLabel(iconoError);
			
			GridBagConstraints c = new GridBagConstraints(1, 0, 1, 1, 0d, 0d, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0),0, 0);
			panel01.add(labelError,c);
//			colocar(1,0,1,1,0,0,30,0,GridBagConstraints.NONE,GridBagConstraints.EAST,0,panel01, labelError);
		}
		{
			reglamento.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
		}
		{
			
			colocar(0,0,4,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.CENTER,5,this, titulo);

			colocar(0,1,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,5,this, tnombre);
			colocar(1,1,1,1,0,0,150,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,5,this, panel01);
			
			colocar(0,2,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,5,this, tdeporte);
			colocar(1,2,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,5,this, combodeporte);
			
			colocar(0,3,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,5,this, tlugar);
			colocar(1,3,2,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST,5,this, tablalugares);
			
			colocar(0,4,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,5,this, tmodalidad);
			colocar(1,4,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,5,this, combomodalidad);
			
			colocar(0,5,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,5,this, tformadepuntuacion);
			colocar(1,5,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,5,this, comboformapuntuacion);
			
			colocar(0,7,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,5,this, treglamento);
			colocar(1,7,2,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST,5,this, reglamento);
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
}
