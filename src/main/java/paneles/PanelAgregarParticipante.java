package paneles;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.stream.Collectors;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

import app.App;
import dominio.Mensaje;
import dtos.ParticipanteDTO;
import dtos.VerInterfazCompetenciaDTO;
import gestores.GestorCompetencia;
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
import gui.PopupConfirmacion;
import gui.PopupError;
import gui.PopupExito;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;

public class PanelAgregarParticipante extends PanelPersonalizado {


	private static final long serialVersionUID = 1L;
	PanelVerParticipantesTM tablemodel;	
	App padre;

	//MyIcon cargando2;
	int idCompetencia;
	String nombreCompetencia;
	PanelAgregarParticipanteConMensajes capas;


	public PanelAgregarParticipante(App padre, int idCompetencia, String nombreCompetencia, PanelAgregarParticipanteConMensajes capas) {

		super();
		this.capas = capas;
		this.idCompetencia=idCompetencia;
		this.nombreCompetencia=nombreCompetencia;
		this.padre = padre;
		GestorDeporte gestorDeporte = new GestorDeporte();
		this.setPreferredSize(new Dimension(710, 300));
		this.setMinimumSize(new Dimension(710, 300));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {570};
		gridBagLayout.rowHeights = new int[] {71, 56, 30};
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

		//		MyIcon cargando1 = new MyIcon("icon/loading3.gif", 30, 30, true);
		//		GridBagConstraints gbc_cargando1 = new GridBagConstraints();
		//		gbc_cargando1.insets = new Insets(0, 0, 0, 5);
		//		gbc_cargando1.gridx = 0;
		//		gbc_cargando1.gridy = 0;
		//		panel.add(cargando1, gbc_cargando1);

		MyTitle myTitle = new MyTitle("Agregar Participate");
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

		tablemodel = new PanelVerParticipantesTM();

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(new Rectangle(30, 50, 0, 0));
		panel_2.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Agregar participante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 20, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{30, 30, 0, 0};
		gbl_panel_2.rowHeights = new int[]{25, 25, 25, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		JLabel label = new JLabel("Nombre del participante/equipo");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHEAST;
		gbc_label.insets = new Insets(5, 5, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);

		MyJTextField camponombre = new MyJTextField("Ingrese uno...");
		GridBagConstraints gbc_camponombre = new GridBagConstraints();
		gbc_camponombre.insets = new Insets(0, 15, 15, 5);
		gbc_camponombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_camponombre.gridx = 1;
		gbc_camponombre.gridy = 0;
		panel_2.add(camponombre, gbc_camponombre);

		MyIcon error1 = new MyIcon("icon/error2.png", 24, 24, false,true,false);
		GridBagConstraints gbc_error1 = new GridBagConstraints();
		gbc_error1.insets = new Insets(0, 0, 5, 0);
		gbc_error1.gridx = 2;
		gbc_error1.gridy = 0;
		panel_2.add(error1, gbc_error1);

		JLabel label_2 = new JLabel("Correo electrónico de contacto");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_label_2.insets = new Insets(5, 5, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_2.add(label_2, gbc_label_2);

		MyJTextField campoemail = new MyJTextField("Ingrese uno...");
		GridBagConstraints gbc_campoemail = new GridBagConstraints();
		gbc_campoemail.insets = new Insets(0, 15, 15, 5);
		gbc_campoemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoemail.gridx = 1;
		gbc_campoemail.gridy = 1;
		panel_2.add(campoemail, gbc_campoemail);

		MyIcon error2 = new MyIcon("icon/error2.png", 24, 24, false,true,false);
		GridBagConstraints gbc_error2 = new GridBagConstraints();
		gbc_error2.insets = new Insets(0, 0, 5, 0);
		gbc_error2.gridx = 2;
		gbc_error2.gridy = 1;
		panel_2.add(error2, gbc_error2);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.EAST;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);

		JButton botoncancelar = new JButton("Cancelar");
		GridBagConstraints gbc_botoncancelar = new GridBagConstraints();
		gbc_botoncancelar.fill = GridBagConstraints.BOTH;
		gbc_botoncancelar.insets = new Insets(0, 0, 0, 5);
		gbc_botoncancelar.gridx = 0;
		gbc_botoncancelar.gridy = 0;
		panel_3.add(botoncancelar, gbc_botoncancelar);
		botoncancelar.addActionListener(e->{
			padre.volverAtras();
		});

		JButton botonagregar = new JButton("    Agregar");
		GridBagConstraints gbc_botonagregar = new GridBagConstraints();
		gbc_botonagregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonagregar.gridx = 1;
		gbc_botonagregar.gridy = 0;
		panel_3.add(botonagregar, gbc_botonagregar);
		botonagregar.setIcon(Gui.emoji("icon/agregarparticipante.png", 24, 24, false));
		botonagregar.setEnabled(false);

		//		PopupConfirmacion p= new PopupConfirmacion();
		//		capas.colocarPopup(p, botonagregar, true);
		//		p.acceptbutton.addActionListener(e->{
		//			
		//		});
		PopupError perror = new PopupError();
		PopupExito pexito = new PopupExito();
		capas.colocarPopup(perror, botonagregar, false);
		capas.colocarPopup(pexito, botonagregar, false);

		camponombre.addChangeListener(e->{
			botonagregar.setEnabled(camponombre.hasChanged() || campoemail.hasChanged());
		});

		campoemail.addChangeListener(e->{
			botonagregar.setEnabled(camponombre.hasChanged() || campoemail.hasChanged());
		});

		botonagregar.addActionListener(e->{
			ParticipanteDTO dto = new ParticipanteDTO(camponombre.getText(), campoemail.getText(), idCompetencia);
			GestorCompetencia gestorCompetencia = new GestorCompetencia();
			GestorParticipante gestorParticipante = new GestorParticipante();
			Mensaje m = new Mensaje(-1,"Error: la competencia ya fue iniciada");
			if(gestorCompetencia.verificarCompetencia(dto) != null) {
				m = gestorParticipante.crearParticipante(dto);
				if(m.getAccion()==0){
					pexito.setText(m.getTexto());
					pexito.setVisible(true);
					return;
				}
			}
			perror.setText(m.getTexto());
			switch (m.getAccion()) {
					case 1:
						capas.colocarPopup(perror, error1, false);
						break;
					case 2:
						capas.colocarPopup(perror, error2, false);
						break;
					case 3:
						capas.colocarPopup(perror, botonagregar, false);
					case -1:
						break;
						
					
			}
			perror.setVisible(true);

		});


		//		SwingWorker<String[], Void> trabajador1 = new SwingWorker<String[], Void>(){
		//			private String[] t;
		//			@Override
		//			protected String[] doInBackground() throws Exception {
		//				t = gestorDeporte
		//						.getAllDeportes()
		//						.stream()
		//						.map(d->d.getNombre())
		//						.collect(Collectors.toList())
		//						.toArray(new String[0]);
		//
		//				return t;
		//			}
		//			@Override 
		//			protected void done() {
		//				if(t!=null) {
		//					combodeporte.setModel(new DefaultComboBoxModel<String>(t!=null?t:new String[] {" "}));
		//					cargando1.setVisible(false);
		//				}
		//			}
		//
		//		};
		//		trabajador1.execute();



	}


}



