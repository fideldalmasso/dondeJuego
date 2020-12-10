package paneles;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

import app.App;
import dtos.VerInterfazCompetenciaDTO;
import gestores.GestorDeporte;
import gestores.GestorParticipante;
import gui.Gui;
import gui.MyIcon;
import gui.MyJComboBox;
import gui.MyJTable;
import gui.MyJTextField;
import gui.MyPaginator;
import gui.MyTitle;
import gui.PanelPersonalizado;

public class PanelVerParticipantes extends PanelPersonalizado {


	private static final long serialVersionUID = 1L;
	PanelVerParticipantesTM tablemodel;	
	App padre;


	MyIcon cargando2;
	VerInterfazCompetenciaDTO filtro;
	MyJTable table;
	MyJTextField camponombre;
	MyJComboBox combodeporte;
	MyJComboBox combomodalidad;
	MyJComboBox comboestado;
	MyPaginator paginador;
	int idCompetencia;
	String nombreCompetencia;


	public PanelVerParticipantes(App padre, int idCompetencia, String nombreCompetencia) {

		super();
		this.idCompetencia=idCompetencia;
		this.nombreCompetencia=nombreCompetencia;
		this.padre = padre;
		GestorDeporte gestorDeporte = new GestorDeporte();
		this.setPreferredSize(new Dimension(890, 790));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {570};
		gridBagLayout.rowHeights = new int[] {71, 56, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(10, 0, 10, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		MyIcon cargando1 = new MyIcon("icon/loading3.gif", 30, 30, true);
		GridBagConstraints gbc_cargando1 = new GridBagConstraints();
		gbc_cargando1.insets = new Insets(0, 0, 0, 5);
		gbc_cargando1.gridx = 0;
		gbc_cargando1.gridy = 0;
		panel.add(cargando1, gbc_cargando1);

		MyTitle myTitle = new MyTitle("Participantes");
		GridBagConstraints gbc_myTitle = new GridBagConstraints();
		gbc_myTitle.gridx = 1;
		gbc_myTitle.gridy = 0;
		panel.add(myTitle, gbc_myTitle);

		JLabel nombrecompetencia = new JLabel("\""+nombreCompetencia+"\"");
		GridBagConstraints gbc_nombrecompetencia = new GridBagConstraints();
		gbc_nombrecompetencia.anchor = GridBagConstraints.NORTH;
		gbc_nombrecompetencia.insets = new Insets(0, 0, 5, 0);
		gbc_nombrecompetencia.gridx = 0;
		gbc_nombrecompetencia.gridy = 1;
		add(nombrecompetencia, gbc_nombrecompetencia);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(10, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		tablemodel = new PanelVerParticipantesTM();

		MyJTable table = new MyJTable(tablemodel);
		table.setJTableColumnsWidth(48,48,2,2);

		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
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

		MyPaginator paginador = new MyPaginator(tablemodel.getRowsperpage());
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

		JButton botoncancelar = new JButton("Cancelar");
		GridBagConstraints gbc_botoncancelar = new GridBagConstraints();
		gbc_botoncancelar.anchor = GridBagConstraints.EAST;
		gbc_botoncancelar.fill = GridBagConstraints.VERTICAL;
		gbc_botoncancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botoncancelar.gridx = 1;
		gbc_botoncancelar.gridy = 0;
		panel_1.add(botoncancelar, gbc_botoncancelar);

		JButton botonagregarparticipante = new JButton("    Agregar participante");
		botonagregarparticipante.setIcon(Gui.emoji("icon/mas_negro.png", 24, 24, false));
		GridBagConstraints gbc_botonagregarparticipante = new GridBagConstraints();
		gbc_botonagregarparticipante.anchor = GridBagConstraints.EAST;

		gbc_botonagregarparticipante.insets = new Insets(0, 0, 5, 0);
		gbc_botonagregarparticipante.gridx = 2;
		gbc_botonagregarparticipante.gridy = 0;
		panel_1.add(botonagregarparticipante, gbc_botonagregarparticipante);


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
				if(t!=null) {
					combodeporte.setModel(new DefaultComboBoxModel<String>(t!=null?t:new String[] {" "}));
					cargando1.setVisible(false);
				}
			}

		};
		trabajador1.execute();


		SwingWorker<PanelVerParticipantesTM, Void> trabajador2 = new SwingWorker<PanelVerParticipantesTM, Void>(){
			private PanelVerParticipantesTM t;
			@Override
			protected PanelVerParticipantesTM doInBackground() throws Exception {
				cargando2.setVisible(true);
				GestorParticipante gestor = new GestorParticipante();
				t= new PanelVerParticipantesTM(gestor.getParticipantes(idCompetencia));
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
					table.setJTableColumnsWidth(48,48,2,2);
					cargando2.setVisible(false);
					paginador.setDataSize(t.getTam());
				}
				else {
					Gui.imprimir("Hubo un error cargando la tabla desde la db");
				}
			}
		};
		trabajador2.execute();




		//		table.addMouseListener(new MouseAdapter() {
		//			public void mouseClicked(MouseEvent e) {
		//				if(table.getSelectedColumn()==4) {
		//					padre.nuevoPanel(new PanelVerCompetencia(padre, (int)tablemodel.getValueAt(table.getSelectedRow(), 5)));
		//					Gui.imprimir("cambiar a panel ver competencia");
		//				}
		//			}
		//		});



		botonagregarparticipante.addActionListener(e->{
			padre.nuevoPanel(new PanelAgregarParticipanteConMensajes(padre, idCompetencia, nombreCompetencia));
		});

		botoncancelar.addActionListener(e->{
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

	//	class trabajador3 extends SwingWorker<PanelMisCompetenciasTM, Void>{
	//		private PanelMisCompetenciasTM t;
	//		@Override
	//		protected PanelMisCompetenciasTM doInBackground() throws Exception {
	//			cargando2.setVisible(true);
	//			VerInterfazCompetenciaDTO filtro = new VerInterfazCompetenciaDTO();
	//			filtro.setNombre(camponombre.getText());
	//			filtro.setDeporte(combodeporte.getSelectedItem());
	//			filtro.setModalidad(combomodalidad.getSelectedItem());
	//			filtro.setEstado(comboestado.getSelectedItem());
	//			t= new PanelMisCompetenciasTM(gestorCompetencia.getCompetencias(filtro));
	//			return t;
	//		}
	//		@Override 
	//		protected void done() {
	//			tablemodel=t;
	//			if(t!=null) { 
	//
	//				table.setModel(t);
	//				table.setJTableColumnsWidth(40,40,10,10);
	//				cargando2.setVisible(false);
	//				paginador.setDataSize(t.getTam());
	//			}
	//			else {
	//				Gui.imprimir("Hubo un error haciendo la consulta en la db");
	//			}
	//		}
	//	}

}



