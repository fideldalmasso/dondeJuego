package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import app.App;
import daos.DeporteDAO;
import dominio.Deporte;
import dtos.VerInterfazCompetenciaDTO;
import gestores.GestorCompetencia;
import gestores.GestorDeporte;
import gui.Gui;
import gui.MyIcon;
import gui.MyJComboBox;
import gui.MyJTable;
import gui.MyJTextField;
import gui.MyPaginator;
import gui.MyTitle;
import gui.PanelPersonalizado;
import guiejemplos.BubbleLabelRight;

public class PanelMisCompetencias extends PanelPersonalizado {

	PanelMisCompetenciasTM tablemodel;	
	App padre;


	MyIcon cargando1;
	MyIcon cargando2;
	VerInterfazCompetenciaDTO filtro;
	MyJTable table;
	MyJTextField camponombre;
	MyJComboBox combodeporte;
	MyJComboBox combomodalidad;
	MyJComboBox comboestado;
	GestorCompetencia gestorCompetencia;
	MyPaginator paginador;

	public PanelMisCompetencias(App padre) {

		super();
		this.padre = padre;
		gestorCompetencia = new GestorCompetencia();
		GestorDeporte gestorDeporte = new GestorDeporte();
		this.setPreferredSize(new Dimension(700, 734));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {142, 0};
		gridBagLayout.rowHeights = new int[] {30, 218, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		setLayout(gridBagLayout);

		MyTitle myTitle = new MyTitle("Mis Competencias");
		GridBagConstraints gbc_myTitle = new GridBagConstraints();
		gbc_myTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_myTitle.insets = new Insets(0, 0, 5, 5);
		gbc_myTitle.gridx = 0;
		gbc_myTitle.gridy = 0;
		add(myTitle, gbc_myTitle);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		panel.setBounds(new Rectangle(30, 50, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 30, 5, 30);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 30, 30, 0};
		gbl_panel.rowHeights = new int[] {20, 30, 30, 30, 30};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Nombre de la competencia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		camponombre = new MyJTextField("Ingrese uno...");
		GridBagConstraints gbc_myJTextField = new GridBagConstraints();
		gbc_myJTextField.insets = new Insets(5, 5, 5, 5);
		gbc_myJTextField.gridwidth = 2;
		gbc_myJTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJTextField.gridx = 1;
		gbc_myJTextField.gridy = 0;
		panel.add(camponombre, gbc_myJTextField);

		JLabel label_2 = new JLabel("Deporte");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(10, 5, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);

		combodeporte = new MyJComboBox();
		GridBagConstraints gbc_myJComboBox = new GridBagConstraints();
		gbc_myJComboBox.gridwidth = 2;
		gbc_myJComboBox.insets = new Insets(10, 5, 5, 5);
		gbc_myJComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJComboBox.gridx = 1;
		gbc_myJComboBox.gridy = 1;
		panel.add(combodeporte, gbc_myJComboBox);

		cargando1 = new MyIcon("icon/loading3.gif",24,24,true);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(cargando1, gbc_lblNewLabel_1);

		JLabel label = new JLabel("Modalidad");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(10, 5, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);

		combomodalidad = new MyJComboBox(new String[] {"Liga", "Eliminatoria Simple", "Eliminatoria Doble" });
		GridBagConstraints gbc_myJComboBox_1 = new GridBagConstraints();
		gbc_myJComboBox_1.gridwidth = 2;
		gbc_myJComboBox_1.insets = new Insets(10, 5, 5, 5);
		gbc_myJComboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJComboBox_1.gridx = 1;
		gbc_myJComboBox_1.gridy = 2;
		panel.add(combomodalidad, gbc_myJComboBox_1);

		JLabel label_1 = new JLabel("Estado");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(10, 5, 5, 10);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		panel.add(label_1, gbc_label_1);

		comboestado = new MyJComboBox(new String[] {"CREADA","PLANIFICADA","ENDISPUTA","FINALIZADA"});
		GridBagConstraints gbc_myJComboBox_2 = new GridBagConstraints();
		gbc_myJComboBox_2.insets = new Insets(10, 5, 5, 5);
		gbc_myJComboBox_2.gridwidth = 2;
		gbc_myJComboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJComboBox_2.gridx = 1;
		gbc_myJComboBox_2.gridy = 3;
		panel.add(comboestado, gbc_myJComboBox_2);

		JButton botonbuscar = new JButton("Buscar");
		botonbuscar.setIcon(Gui.emoji("icon/lupa.png", 24, 24, false));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(5, 5, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 4;
		panel.add(botonbuscar, gbc_btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(10, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		tablemodel = new PanelMisCompetenciasTM();

		table = new MyJTable(tablemodel);
		table.setJTableColumnsWidth(36,14,25,19,6);

		scrollPane.setViewportView(table);

		cargando2 = new MyIcon("icon/loading3.gif",24,24,true,false,true);
		GridBagConstraints gbc_cargando2 = new GridBagConstraints();
		gbc_cargando2.anchor = GridBagConstraints.NORTH;
		gbc_cargando2.insets = new Insets(0, 0, 5, 0);
		gbc_cargando2.gridx = 1;
		gbc_cargando2.gridy = 2;
		add(cargando2, gbc_cargando2);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{334, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		paginador = new MyPaginator(tablemodel.getRowsperpage());
		GridBagLayout gridBagLayout_1 = (GridBagLayout) paginador.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0};
		gridBagLayout_1.rowHeights = new int[]{23};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout_1.columnWidths = new int[]{25, 25, 25, 25, 0};
		GridBagConstraints gbc_myPaginator = new GridBagConstraints();
		gbc_myPaginator.anchor = GridBagConstraints.WEST;
		gbc_myPaginator.insets = new Insets(0, 0, 5, 5);
		gbc_myPaginator.fill = GridBagConstraints.VERTICAL;
		gbc_myPaginator.gridx = 0;
		gbc_myPaginator.gridy = 0;
		panel_1.add(paginador, gbc_myPaginator);

		JButton botonvolver = new JButton("Volver");
		GridBagConstraints gbc_botonvolver = new GridBagConstraints();
		gbc_botonvolver.anchor = GridBagConstraints.EAST;
		gbc_botonvolver.fill = GridBagConstraints.VERTICAL;
		gbc_botonvolver.insets = new Insets(0, 0, 5, 5);
		gbc_botonvolver.gridx = 1;
		gbc_botonvolver.gridy = 0;
		panel_1.add(botonvolver, gbc_botonvolver);

		JButton botonnuevacompetancia = new JButton("    Nueva competencia");
		botonnuevacompetancia.setIcon(Gui.emoji("icon/mas_negro.png", 24, 24, false));
		GridBagConstraints gbc_nuevacompetencia = new GridBagConstraints();
		gbc_nuevacompetencia.anchor = GridBagConstraints.EAST;

		gbc_nuevacompetencia.insets = new Insets(0, 0, 5, 0);
		gbc_nuevacompetencia.gridx = 2;
		gbc_nuevacompetencia.gridy = 0;
		panel_1.add(botonnuevacompetancia, gbc_nuevacompetencia);


		SwingWorker<String[], Void> trabajador1 = new SwingWorker<String[], Void>(){
			private String[] t;
			@Override
			protected String[] doInBackground() throws Exception {
				t = gestorDeporte
						.getAllDeportes()
						.stream()
						.map(d->d.getNombre())
						.collect(Collectors.toList())
						.toArray(new String[0]);

				return t;
			}
			@Override 
			protected void done() {
				combodeporte.setModel(new DefaultComboBoxModel<String>(t!=null?t:new String[] {" "}));
				cargando1.setVisible(false);
			}

		};
		trabajador1.execute();


		SwingWorker<PanelMisCompetenciasTM, Void> trabajador2 = new SwingWorker<PanelMisCompetenciasTM, Void>(){
			private PanelMisCompetenciasTM t;
			@Override
			protected PanelMisCompetenciasTM doInBackground() throws Exception {
				cargando2.setVisible(true);
				t= new PanelMisCompetenciasTM(gestorCompetencia.getCompetencias());
//				List<VerInterfazCompetenciaDTO> lista = new ArrayList<VerInterfazCompetenciaDTO>();
//				for(int i=0; i<50; i++) {
//					lista.add(new VerInterfazCompetenciaDTO(i, "xd"+i, "xd", "xd", "xd"));
//				}
//				t = new PanelMisCompetenciasTM(lista);
				return t;
			}
			@Override 
			protected void done() {
				tablemodel=t;
				if(t!=null) { 
					table.setModel(t);
					table.setJTableColumnsWidth(36,14,25,19,6);
					cargando2.setVisible(false);
					paginador.setDataSize(t.getTam());
				}
				else {
					Gui.imprimir("Hubo un error cargando la tabla desde la db");
				}
			}
		};
		trabajador2.execute();




		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedColumn()==4) {
					padre.nuevoPanel(new PanelVerCompetenciaConMensajes(padre, (int)tablemodel.getValueAt(table.getSelectedRow(), 5)));
					Gui.imprimir("cambiar a panel ver competencia");
				}
			}
		});

		botonbuscar.addActionListener(e->{
			PanelMisCompetencias.Trabajador3 t  = this.new Trabajador3();
			t.execute();
		});



		botonnuevacompetancia.addActionListener(e->{
			padre.nuevoPanel(new PanelAltaCompetenciaConMensajes(padre));
		});

		botonvolver.addActionListener(e->{
			padre.volverAtras();
		});

		paginador.getFirst().addActionListener(e->{
			tablemodel.setActualPage(1);
		});
		paginador.getBack().addActionListener(e->{
			tablemodel.setActualPage(tablemodel.getActualpage()-1);
		});
		paginador.getNext().addActionListener(e->{
			tablemodel.setActualPage(tablemodel.getActualpage()+1);
		});
		paginador.getLast().addActionListener(e->{
			tablemodel.setActualPage(tablemodel.getTotalpages());
		});



	}

	class Trabajador3 extends SwingWorker<PanelMisCompetenciasTM, Void>{
		

		public PanelMisCompetenciasTM t;
		@Override
		public PanelMisCompetenciasTM doInBackground() throws Exception {
			PanelMisCompetencias.this.cargando2.setVisible(true);
			VerInterfazCompetenciaDTO filtro = new VerInterfazCompetenciaDTO();
			filtro.setNombre(PanelMisCompetencias.this.camponombre.getText());
			filtro.setDeporte(PanelMisCompetencias.this.combodeporte.getSelectedItem());
			filtro.setModalidad(PanelMisCompetencias.this.combomodalidad.getSelectedItem());
			filtro.setEstado(PanelMisCompetencias.this.comboestado.getSelectedItem());
			this.t= new PanelMisCompetenciasTM(PanelMisCompetencias.this.gestorCompetencia.getCompetencias(filtro));
			return this.t;
		}
		@Override 
		public void done() {
			PanelMisCompetencias.this.tablemodel=this.t;
			if(this.t!=null) { 

				PanelMisCompetencias.this.table.setModel(this.t);
				PanelMisCompetencias.this.table.setJTableColumnsWidth(36,14,25,19,6);
				PanelMisCompetencias.this.cargando2.setVisible(false);
				PanelMisCompetencias.this.paginador.setDataSize(this.t.getTam());
//				PanelMisCompetencias.this.paginador.setPage(1);
			}
			else {
				Gui.imprimir("Hubo un error haciendo la consulta en la db");
			}
		}
	

}
}



