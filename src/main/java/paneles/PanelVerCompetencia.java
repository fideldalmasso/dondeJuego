package paneles;

import java.awt.Dimension;

import gui.PanelPersonalizado;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import gui.MyTitle;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import app.App;
import daos.DeporteDAO;
import dtos.CompetenciaDTO;
import dtos.VerCompetenciaDTO;
import gestores.GestorCompetencia;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import gui.MyJTextField;
import gui.MyJComboBox;
import gui.Gui;
import gui.MyIcon;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

import gui.MyJTable;

public class PanelVerCompetencia extends PanelPersonalizado {

	private static final long serialVersionUID = 1L;

	App padre;
	
	public MyJTable tabla1;
	public MyJTable tabla2;
	public PanelVerCompetenciaTM1 tablemodel1;
	public PanelVerCompetenciaTM2 tablemodel2;
	private int idCompetencia;
	
	public JButton botongenerarfixture;
	public MyIcon iconolapiz;
	private GestorCompetencia gestor;
	private VerCompetenciaDTO dto;
	
	private String nombreCompetencia ="";
	
	public PanelVerCompetencia(App padre, int idCompetencia) {
		super();
		gestor = new GestorCompetencia();
		this.idCompetencia=idCompetencia;
		this.padre=padre;
		this.setPreferredSize(new Dimension(700,734));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{89, 149, 202, 203, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 200, 30, 30};
		gbl_panel.rowHeights = new int[]{67, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		MyIcon iconocargando = new MyIcon("icon/loading3.gif", 30, 30, true);
		GridBagConstraints gbc_iconocargando = new GridBagConstraints();
		gbc_iconocargando.anchor = GridBagConstraints.EAST;
		gbc_iconocargando.insets = new Insets(0, 40, 0, 5);
		gbc_iconocargando.gridx = 0;
		gbc_iconocargando.gridy = 0;
		panel.add(iconocargando, gbc_iconocargando);
		
		MyTitle myTitle = new MyTitle("Competencia");
		GridBagConstraints gbc_myTitle = new GridBagConstraints();
		gbc_myTitle.insets = new Insets(0, 0, 0, 5);
		gbc_myTitle.gridx = 1;
		gbc_myTitle.gridy = 0;
		panel.add(myTitle, gbc_myTitle);
		
		iconolapiz = new MyIcon("icon/lapiz.png", 30, 30, false);
		GridBagConstraints gbc_iconolapiz = new GridBagConstraints();
		gbc_iconolapiz.anchor = GridBagConstraints.WEST;
		gbc_iconolapiz.insets = new Insets(0, 20, 0, 20);
		gbc_iconolapiz.gridx = 2;
		gbc_iconolapiz.gridy = 0;
		panel.add(iconolapiz, gbc_iconolapiz);
		
		MyIcon iconobasura = new MyIcon("icon/basura.png", 30, 30, false);
		GridBagConstraints gbc_iconobasura = new GridBagConstraints();
		gbc_iconobasura.anchor = GridBagConstraints.WEST;
		gbc_iconobasura.gridx = 3;
		gbc_iconobasura.gridy = 0;
		panel.add(iconobasura, gbc_iconobasura);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(new Rectangle(30, 50, 0, 0));
		panel_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 15, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{30, 30, 0, 0};
		gbl_panel_1.rowHeights = new int[] {25, 25, 25, 25};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel labelnombre = new JLabel("Nombre de la competencia:");
		GridBagConstraints gbc_labelnombre = new GridBagConstraints();
		gbc_labelnombre.anchor = GridBagConstraints.WEST;
		gbc_labelnombre.insets = new Insets(5, 5, 5, 5);
		gbc_labelnombre.gridx = 0;
		gbc_labelnombre.gridy = 0;
		panel_1.add(labelnombre, gbc_labelnombre);
		
		JLabel nombre = new JLabel("");
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.WEST;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 0;
		panel_1.add(nombre, gbc_nombre);
		
		JLabel labelmodalidad = new JLabel("Modalidad de la competencia:");
		GridBagConstraints gbc_labelmodalidad = new GridBagConstraints();
		gbc_labelmodalidad.anchor = GridBagConstraints.WEST;
		gbc_labelmodalidad.insets = new Insets(5, 5, 5, 5);
		gbc_labelmodalidad.gridx = 0;
		gbc_labelmodalidad.gridy = 1;
		panel_1.add(labelmodalidad, gbc_labelmodalidad);
		
		JLabel modalidad = new JLabel("");
		GridBagConstraints gbc_modalidad = new GridBagConstraints();
		gbc_modalidad.anchor = GridBagConstraints.WEST;
		gbc_modalidad.insets = new Insets(0, 0, 5, 5);
		gbc_modalidad.gridx = 1;
		gbc_modalidad.gridy = 1;
		panel_1.add(modalidad, gbc_modalidad);
		
		JLabel labeldeporte = new JLabel("Deporte asociado:");
		GridBagConstraints gbc_labeldeporte = new GridBagConstraints();
		gbc_labeldeporte.anchor = GridBagConstraints.WEST;
		gbc_labeldeporte.insets = new Insets(5, 5, 5, 5);
		gbc_labeldeporte.gridx = 0;
		gbc_labeldeporte.gridy = 2;
		panel_1.add(labeldeporte, gbc_labeldeporte);
		
		JLabel deporte = new JLabel("");
		GridBagConstraints gbc_deporte = new GridBagConstraints();
		gbc_deporte.anchor = GridBagConstraints.WEST;
		gbc_deporte.insets = new Insets(0, 0, 5, 5);
		gbc_deporte.gridx = 1;
		gbc_deporte.gridy = 2;
		panel_1.add(deporte, gbc_deporte);
		
		JLabel labelestado = new JLabel("Estado:");
		GridBagConstraints gbc_labelestado = new GridBagConstraints();
		gbc_labelestado.anchor = GridBagConstraints.WEST;
		gbc_labelestado.insets = new Insets(5, 5, 0, 5);
		gbc_labelestado.gridx = 0;
		gbc_labelestado.gridy = 3;
		panel_1.add(labelestado, gbc_labelestado);
		
		JLabel estado = new JLabel("");
		GridBagConstraints gbc_estado = new GridBagConstraints();
		gbc_estado.anchor = GridBagConstraints.WEST;
		gbc_estado.insets = new Insets(0, 0, 0, 5);
		gbc_estado.gridx = 1;
		gbc_estado.gridy = 3;
		panel_1.add(estado, gbc_estado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(new Rectangle(30, 50, 0, 0));
		panel_2.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Participantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 15, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{30, 0};
		gbl_panel_2.rowHeights = new int[]{20, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		
		tablemodel1 = new PanelVerCompetenciaTM1();
		tabla1 = new MyJTable(tablemodel1);
		JScrollPane scrollPane1 = new JScrollPane(tabla1);
		
		
		
		GridBagConstraints gbc_scrollPane1 = new GridBagConstraints();
		gbc_scrollPane1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane1.gridx = 0;
		gbc_scrollPane1.gridy = 0;
		panel_2.add(scrollPane1, gbc_scrollPane1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(new Rectangle(30, 50, 0, 0));
		panel_3.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Pr\u00F3ximos encuentros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 10, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{30, 0};
		gbl_panel_3.rowHeights = new int[]{20, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		
		tablemodel2 = new PanelVerCompetenciaTM2();
		tabla2 = new MyJTable(tablemodel2);
		JScrollPane scrollPane2 = new JScrollPane(tabla2);
		tabla2.setJTableColumnsWidth(31,31,7,31);
		
		
		GridBagConstraints gbc_scrollPane2 = new GridBagConstraints();
		gbc_scrollPane2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane2.gridx = 0;
		gbc_scrollPane2.gridy = 0;
		panel_3.add(scrollPane2, gbc_scrollPane2);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JButton botonverfixture = new JButton("Ver fixture");
		GridBagConstraints gbc_botonverfixture = new GridBagConstraints();
		gbc_botonverfixture.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonverfixture.insets = new Insets(0, 0, 5, 8);
		gbc_botonverfixture.gridx = 0;
		gbc_botonverfixture.gridy = 0;
		panel_4.add(botonverfixture, gbc_botonverfixture);
		
		botongenerarfixture = new JButton("Generar fixture");
		GridBagConstraints gbc_botongenerarfixture = new GridBagConstraints();
		gbc_botongenerarfixture.fill = GridBagConstraints.HORIZONTAL;
		gbc_botongenerarfixture.insets = new Insets(0, 0, 5, 8);
		gbc_botongenerarfixture.gridx = 1;
		gbc_botongenerarfixture.gridy = 0;
		panel_4.add(botongenerarfixture, gbc_botongenerarfixture);
//		botongenerarfixture.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentMoved(ComponentEvent e) {
//				super.componentMoved(e);
//				Gui.imprimir(botongenerarfixture.getLocation().toString());
//			}
//		});
		
		
		
		JButton botonvertablaposiciones = new JButton("Ver tabla de posiciones");
		GridBagConstraints gbc_botonvertablaposiciones = new GridBagConstraints();
		gbc_botonvertablaposiciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonvertablaposiciones.insets = new Insets(0, 0, 5, 8);
		gbc_botonvertablaposiciones.anchor = GridBagConstraints.NORTH;
		gbc_botonvertablaposiciones.gridx = 2;
		gbc_botonvertablaposiciones.gridy = 0;
		panel_4.add(botonvertablaposiciones, gbc_botonvertablaposiciones);
		
		JButton botonverparticipantes = new JButton("Ver participantes");
		GridBagConstraints gbc_botonverparticipantes = new GridBagConstraints();
		gbc_botonverparticipantes.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonverparticipantes.insets = new Insets(0, 0, 5, 0);
		gbc_botonverparticipantes.gridx = 3;
		gbc_botonverparticipantes.gridy = 0;
		panel_4.add(botonverparticipantes, gbc_botonverparticipantes);
		botonverparticipantes.setEnabled(false);
		botonverparticipantes.addActionListener(e->{
			padre.nuevoPanel(new PanelVerParticipantes(padre, idCompetencia, nombreCompetencia));
		});
		
		
		
		JButton botoncancelar = new JButton("Cancelar");
		GridBagConstraints gbc_botoncancelar = new GridBagConstraints();
		gbc_botoncancelar.gridwidth = 4;
		gbc_botoncancelar.insets = new Insets(5, 0, 10, 5);
		gbc_botoncancelar.gridx = 0;
		gbc_botoncancelar.gridy = 1;
		panel_4.add(botoncancelar, gbc_botoncancelar);
		
		botoncancelar.addActionListener(e->{
			padre.volverAtras();
		});
		
		SwingWorker<VerCompetenciaDTO, Void> trabajador1 = new SwingWorker<VerCompetenciaDTO, Void>(){
			private VerCompetenciaDTO t;
			@Override
			protected VerCompetenciaDTO doInBackground() throws Exception {
				gestor = new GestorCompetencia();
				t= gestor.getCompetenciaDTO(idCompetencia);
				dto = t;
				return t;
			}
			@Override 
			protected void done() {
				
				if(t==null || t.getNombre()== null || t.getModalidad()==null || t.getDeporte() == null || t.getEstado() == null || t.getParticipantes()==null || t.getProximosEncuetros()==null) {
					Gui.imprimir("El dto VerCompetenciaDTO tiene campos nulos REVISAR!");
					if(t==null)
						Gui.imprimir("El dto es null");
					return;
				}
				nombreCompetencia = t.getNombre();
				botonverparticipantes.setEnabled(true);
				nombre.setText(t.getNombre());
				modalidad.setText(t.getModalidad());
				deporte.setText(t.getDeporte());
				estado.setText(t.getEstado());
			
				if(estado.getText().equals("En disputa") || estado.getText().equals("Finalizada") || modalidad.getText().equals("Eliminatoria doble") || modalidad.getText().equals("Eliminatoria Simple"))
					botongenerarfixture.setEnabled(false);
				
				tabla1.setModel(new PanelVerCompetenciaTM1(t));
				tabla2.setModel(new PanelVerCompetenciaTM2(t));
				tabla2.setJTableColumnsWidth(31,31,7,31);
				iconocargando.setVisible(false);
			}
			
		};
		trabajador1.execute();
		
		
		
	}
}