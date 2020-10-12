package gui;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.*;

import daos.DeporteDAO;

public class PanelAltaCompetencia extends PanelPersonalizado {//OJO: ESTA CLASE ES OBSOLETA. VER PANELALTACOMPETENCIA2!!!

	private static final long serialVersionUID = 1L;
	private MyTitle titulo = new MyTitle("Crear competencia"); 
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
	private MyJComboBox combomodalidad;
	private MyJComboBox comboformapuntuacion;
	private MyJTextArea reglamento= new MyJTextArea("Ingrese uno...");
	
	private JSpinner[] spinner = new ArrayList<JSpinner>(5).toArray(new JSpinner[5]);
	private JPanel panelSpinner[] = new ArrayList<JPanel>(5).toArray(new JPanel[5]);
	private SpinnerModel[] spinnermodel = new ArrayList<SpinnerModel>(5).toArray(new SpinnerModel[5]);
	private String tspinner[] = {"Puntos por partido ganado","Puntos por empate","Puntos por presentarse","Cantidad de sets","Puntos por abandono"};
	private JLabel lspinner[] = new ArrayList<JLabel>(5).toArray(new JLabel[5]);
//	private JLabel tpuntosporpartidoganado = new JLabel("Puntos por partido ganado",SwingConstants.LEFT);
//	private JLabel tcantidaddesets= new JLabel("Cantidad de sets",SwingConstants.LEFT);
//	private JLabel tpuntosporempate = new JLabel("Puntos por empate",SwingConstants.LEFT);
//	private JLabel tpuntosporabandono = new JLabel("Puntos por abandono",SwingConstants.LEFT);
//	private JLabel tpuntosporpresentarse = new JLabel("Puntos por presentarse",SwingConstants.LEFT);
	
	private MyError error1[]= new ArrayList<MyError>(5).toArray(new MyError[5]);
	private MyError error2[]= new ArrayList<MyError>(5).toArray(new MyError[5]);
	
	private JPanel panel[] = new ArrayList<JPanel>(10).toArray(new JPanel[10]);
	private JCheckBox checkempate = new JCheckBox();
	private JPanel panelEmpate = new JPanel(new GridBagLayout());
	private JPanel panelBotones= new JPanel(new GridBagLayout());
	private JButton botonaceptar = new JButton("Aceptar");
	private JButton botoncancelar = new JButton("Cancelar");
	//private JPanel pnombre,pdeporte,panel03;
	
	
	
	private DeporteDAO dao= new DeporteDAO();
	
	public PanelAltaCompetencia() { 
		this.setPreferredSize(new Dimension(780, 734));
//		this.setBackground(new Color(250, 216, 214));
		this.setLayout(new GridBagLayout());
		System.out.println("Estás usando una clase obsoleta. Probá usar Panel Alta Competencia2");
		
		{
			error1[0] = new MyError("error1");
			panel[0] = crearComponenteConError(nombre, error1[0]);
			error1[0].setEnabled(false);
			
		}
		{
			String listaDeportes[] = dao.getAll().stream().map(d->d.getNombre()).collect(Collectors.toList()).toArray(new String[0]);
			//String listaDeportes[] = {"futbol", "basket"};
			combodeporte = new JComboBox<String>(listaDeportes);
//			combodeporte.setSelectedIndex(0);
			error1[1] = new MyError();
			panel[1]= crearComponenteConError(combodeporte, error1[1]);
			error1[1].setEnabled(false);
			
		}
		{
			//[width=165,height=20]
			tablemodel = new LugarRealizacionTM();
			tablalugares = new MyJTable(tablemodel);
			
			tablalugares.setColumnWidths(20,290,100);
			scrollpanelugares = new JScrollPane(tablalugares);

			error1[2] = new MyError();
			panel[2]= crearComponenteConError(scrollpanelugares, error1[2]);
			error1[2].setEnabled(false);
		
		}
		{
			String listaModalidades[] = {"Liga","Eliminatoria simple", "Eliminatoria doble"};
			combomodalidad = new MyJComboBox(listaModalidades);
			combomodalidad.setSelectedIndex(0);
			error1[3] = new MyError();
			panel[3]= crearComponenteConError(combomodalidad, error1[3]);
			error1[3].setEnabled(false);
		}
		{
			String listaFormasPuntuacion[] = {"Sets", "Puntuación", "Resultado final"};
			comboformapuntuacion= new MyJComboBox(listaFormasPuntuacion);
			comboformapuntuacion.setSelectedIndex(0);
			
			error1[4] = new MyError();
			panel[4]= crearComponenteConError(comboformapuntuacion, error1[4]);
			error1[4].setEnabled(false);
		}
		{
			panelEmpate.add(tempatepermitido);
			panelEmpate.add(checkempate);
			spinnermodel[0] = new SpinnerNumberModel(3, 1, 100, 1);
			spinnermodel[1] = new SpinnerNumberModel(1, 0, 100, 1);
			spinnermodel[2] = new SpinnerNumberModel(0, 0, 100, 1);
			spinnermodel[3] = new SpinnerNumberModel(3, 1, 100, 2);
			spinnermodel[4] = new SpinnerNumberModel(3, 0, 100, 1);
			
			for (int i = 0; i < 5; i++) {
				error2[i] = new MyError();
				spinner[i] = new JSpinner(spinnermodel[i]);
				lspinner[i] = new JLabel(tspinner[i]);
				panelSpinner[i]=crearComponenteConErrorYLabel(lspinner[i], spinner[i],error2[i]);
			}
			
			lspinner[1].setEnabled(false);
			spinner[1].setEnabled(false);
		}
		{
			reglamento.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
			panelBotones.add(botoncancelar);
			panelBotones.add(new JLabel("    "));
			colocar2(2, 0, 1, 1, 0, 0, 0, 0, GridBagConstraints.NONE, GridBagConstraints.WEST, insetvacio, panelBotones, botonaceptar);
		}
		
		{
			
			//enable y disable automaticos
//			combomodalidad.enableComponentOnlyWhenSelected("Liga", spinner[0],checkempate,spinner[2]);
			
			combomodalidad.addActionListener(e->{
				Boolean value = combomodalidad.getSelectedItem().equals("Liga");
				lspinner[0].setEnabled(value);
				spinner[0].setEnabled(value);
				error2[0].setVisible(value);
				
				lspinner[2].setEnabled(value);
				spinner[2].setEnabled(value);
				error2[2].setVisible(value);

				tempatepermitido.setEnabled(value);
				checkempate.setSelected(false);
				checkempate.setEnabled(value);
				error2[1].setVisible(value);
				if(!value) {
					lspinner[1].setEnabled(value);
					spinner[1].setEnabled(value);
				}
				
			});
			comboformapuntuacion.addActionListener(e->{
				String value = (String)comboformapuntuacion.getSelectedItem();
				
				lspinner[3].setEnabled(value.equals("Sets"));
				spinner[3].setEnabled(value.equals("Sets"));
				error2[3].setVisible(value.equals("Sets"));
				
				lspinner[4].setEnabled(value.equals("Puntuación"));
				spinner[4].setEnabled(value.equals("Puntuación"));
				error2[4].setVisible(value.equals("Puntuación"));
			});
//			comboformapuntuacion.enableComponentOnlyWhenSelected("Puntuación", spinner[4]);
//			comboformapuntuacion.enableComponentOnlyWhenSelected("Sets", spinner[3]);
			
			checkempate.addActionListener(e->{
				lspinner[1].setEnabled(checkempate.isSelected());
				spinner[1].setEnabled(checkempate.isSelected());
				error2[1].setVisible(checkempate.isSelected());
			});
		}
		{
			
			colocar(0,0,4,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.CENTER,this, titulo);

			colocar(0,1,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tnombre);
			colocar(1,1,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[0]);
			
			colocar(0,2,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tdeporte);
			colocar(1,2,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[1]);
			
			colocar(0,3,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,this, tlugar);
			colocar(1,3,2,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST,this, panel[2]);
			
			colocar(0,4,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tmodalidad);
			colocar(1,4,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[3]);
			
			colocar(0,5,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, tformadepuntuacion);
			colocar(1,5,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,this, panel[4]);
			
			
			
			colocar(1,6,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[0]);
			
			colocar(0,7,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelEmpate);
			colocar(1,7,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[1]);
			colocar(1,8,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[2]);
			
			colocar(2,6,1,1,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[3]);
			colocar(2,7,1,1,1,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,this, panelSpinner[4]);
			
			
			colocar(0,9,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,this, treglamento);
			colocar(1,9,2,1,1,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST,this, reglamento);
			
			colocar(2,10,1,1,0,0,0,0,GridBagConstraints.NONE,GridBagConstraints.WEST,this, panelBotones);
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
}
