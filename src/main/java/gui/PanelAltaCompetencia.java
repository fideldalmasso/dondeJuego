package gui;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import gestores.GestorCompetencia;

public class PanelAltaCompetencia extends PanelPersonalizado {

	private static final long serialVersionUID = 1L;
	private JLabel titulo = crearTitulo("Crear competencia"); 
	private JLabel tnombre = new JLabel("Nombre",SwingConstants.LEFT);
	private JLabel tdeporte = new JLabel("Deporte",SwingConstants.LEFT);
	private JLabel tlugar = new JLabel("Lugar(Disponibilidad)",SwingConstants.LEFT);
	private JLabel tmodalidad = new JLabel("Modalidad",SwingConstants.LEFT);
	private JLabel tformadepuntuacion = new JLabel("Forma de puntuación",SwingConstants.LEFT);
	private JLabel treglamento = new JLabel("Reglamento",SwingConstants.LEFT);
	private JLabel tempatepermitido = new JLabel("Empate permitido",SwingConstants.LEFT);
	
	private JScrollPane scrollpanelugares;
	private MyJTable tablalugares;
	private LugarRealizacionTM tablemodel;
	
	private MyJTextField nombre = new MyJTextField("Ingrese uno..");
	private JComboBox<String> combodeporte = new JComboBox<String>();
	private JComboBox<String> combomodalidad = new JComboBox<String>();
	private JComboBox<String> comboformapuntuacion = new JComboBox<String>();
	private MyJTextArea reglamento= new MyJTextArea("Ingrese uno...");
	
	private JSpinner[] spinner = new ArrayList<JSpinner>(5).toArray(new JSpinner[5]);
	private JPanel panelSpinner[] = new ArrayList<JPanel>(5).toArray(new JPanel[5]);
	private SpinnerModel[] spinnermodel = new ArrayList<SpinnerModel>(5).toArray(new SpinnerModel[5]);
	private String tspinner[] = {"Puntos por partido ganado","Puntos por empate","Puntos por presentarse","Cantidad de sets","Puntos por abandono"};
//	private JLabel tpuntosporpartidoganado = new JLabel("Puntos por partido ganado",SwingConstants.LEFT);
//	private JLabel tcantidaddesets= new JLabel("Cantidad de sets",SwingConstants.LEFT);
//	private JLabel tpuntosporempate = new JLabel("Puntos por empate",SwingConstants.LEFT);
//	private JLabel tpuntosporabandono = new JLabel("Puntos por abandono",SwingConstants.LEFT);
//	private JLabel tpuntosporpresentarse = new JLabel("Puntos por presentarse",SwingConstants.LEFT);
	
	private Error error1[]= new ArrayList<Error>(5).toArray(new Error[5]);
	private Error error2[]= new ArrayList<Error>(5).toArray(new Error[5]);
	
	private JPanel panel[] = new ArrayList<JPanel>(10).toArray(new JPanel[10]);
	
	//private JPanel pnombre,pdeporte,panel03;
	
	
	
	private GestorCompetencia gc= new GestorCompetencia();
	
	public PanelAltaCompetencia() {
		this.setPreferredSize(new Dimension(750, 734));
//		this.setBackground(new Color(250, 216, 214));
		this.setLayout(new GridBagLayout());
		
		
		{
			error1[0] = new Error("error1");
			panel[0] = crearComponenteConError(nombre, error1[0]);
			error1[0].setEnabled(false);
			
		}
		{
			String listaDeportes[] = gc.getAllDeportes().stream().map(d->d.getNombre()).collect(Collectors.toList()).toArray(new String[0]);
			//String listaDeportes[] = {"futbol", "basket"};
			combodeporte = new JComboBox<String>(listaDeportes);
//			combodeporte.setSelectedIndex(0);
			error1[1] = new Error();
			panel[1]= crearComponenteConError(combodeporte, error1[1]);
			error1[1].setEnabled(false);
			
		}
		{
			//[width=165,height=20]
			tablemodel = new LugarRealizacionTM();
			tablalugares = new MyJTable(tablemodel);
			
			tablalugares.setColumnWidths(20,290,100);
			scrollpanelugares = new JScrollPane(tablalugares);

			error1[2] = new Error();
			panel[2]= crearComponenteConError(scrollpanelugares, error1[2]);
			error1[2].setEnabled(false);
		
		}
		{
			String listaModalidades[] = {"Liga","Eliminatoria simple", "Eliminatoria doble"};
			combomodalidad = new JComboBox<String>(listaModalidades);
			combomodalidad.setSelectedIndex(0);
			error1[3] = new Error();
			panel[3]= crearComponenteConError(combomodalidad, error1[3]);
			error1[3].setEnabled(false);
		}
		{
			String listaFormasPuntuacion[] = {"Sets", "Puntuación", "Resultado final"};
			comboformapuntuacion= new JComboBox<String>(listaFormasPuntuacion);
			comboformapuntuacion.setSelectedIndex(0);
			error1[4] = new Error();
			panel[4]= crearComponenteConError(comboformapuntuacion, error1[4]);
			error1[4].setEnabled(false);
		}
		{
			spinnermodel[0] = new SpinnerNumberModel(3, 1, 100, 1);
			spinnermodel[1] = new SpinnerNumberModel(1, 0, 100, 1);
			spinnermodel[2] = new SpinnerNumberModel(0, 0, 100, 1);
			spinnermodel[3] = new SpinnerNumberModel(3, 1, 100, 2);
			spinnermodel[4] = new SpinnerNumberModel(3, 0, 100, 1);
			
			for (int i = 0; i < 5; i++) {
				error2[i] = new Error();
				panelSpinner[i]=crearComponenteConErrorYLabel(new JLabel(tspinner[i]), new JSpinner(spinnermodel[i]),error2[i]);
			}
			
		}
		
		
		{
			reglamento.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
		}
		{
			
			colocar(0,0,4,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.CENTER,this, titulo);

			colocar(0,1,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tnombre);
			colocar(1,1,1,1,0,0,150,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[0]);
			
			colocar(0,2,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tdeporte);
			colocar(1,2,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[1]);
			
			colocar(0,3,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,this, tlugar);
			colocar(1,3,2,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST,this, panel[2]);
			
			colocar(0,4,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tmodalidad);
			colocar(1,4,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[3]);
			
			colocar(0,5,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tformadepuntuacion);
			colocar(1,5,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[4]);
			
			
			
			colocar(1,6,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[0]);
			colocar(1,7,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[1]);
			colocar(1,8,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[2]);
			
			colocar(2,6,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[3]);
			colocar(2,7,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[4]);
			
			
			colocar(0,9,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,this, treglamento);
			colocar(1,9,2,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST,this, reglamento);
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
}
