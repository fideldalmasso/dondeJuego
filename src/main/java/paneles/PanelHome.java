package paneles;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import app.App;
import gui.MyHomeButton;
import gui.MyTitle;
import gui.PanelPersonalizado;

public class PanelHome extends PanelPersonalizado {
	
	
	private static final long serialVersionUID = 1L;

	private App padre;
	
	
	public PanelHome(App padre) {
		this.padre = padre;
		this.setPreferredSize(new Dimension(850,610));
		this.setMaximumSize(new Dimension(850,610));
		this.setMinimumSize(new Dimension(850,610));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		MyTitle myTitle = new MyTitle("Home");
		GridBagConstraints gbc_myTitle = new GridBagConstraints();
		gbc_myTitle.insets = new Insets(0, 0, 5, 0);
		gbc_myTitle.gridx = 0;
		gbc_myTitle.gridy = 0;
		add(myTitle, gbc_myTitle);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		MyHomeButton botonnuevacompetencia = new MyHomeButton("Nueva competencia","icon/mas_grande.png");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(botonnuevacompetencia, gbc_btnNewButton);
		botonnuevacompetencia.addActionListener(e->{
			padre.nuevoPanel(new PanelAltaCompetenciaConMensajes(padre));
		});
		
		MyHomeButton botonmiscompetencias = new MyHomeButton("Mis competencias", "icon/trofeo_lupa.png");
		GridBagConstraints gbc_botonmiscompetencias = new GridBagConstraints();
		gbc_botonmiscompetencias.gridx = 1;
		gbc_botonmiscompetencias.gridy = 0;
		panel.add(botonmiscompetencias, gbc_botonmiscompetencias);
		botonmiscompetencias.addActionListener(e->{
			padre.nuevoPanel(new PanelMisCompetencias(padre));
		});
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {10, 10, 10};
		gbl_panel_1.rowHeights = new int[] {10};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0};
		panel_1.setLayout(gbl_panel_1);
		
		MyHomeButton botontodaslascompetencias = new MyHomeButton("Todas las competencias", "icon/trofeos.png");
		GridBagConstraints gbc_botontodaslascompetencias = new GridBagConstraints();
		gbc_botontodaslascompetencias.insets = new Insets(0, 0, 0, 5);
		gbc_botontodaslascompetencias.gridx = 0;
		gbc_botontodaslascompetencias.gridy = 0;
		panel_1.add(botontodaslascompetencias, gbc_botontodaslascompetencias);
//		botontodaslascompetencias.addActionListener(e->{
//			padre.nuevoPanel(new PanelVerCompetenciaConMensajes(padre,1));
//		});
		
		MyHomeButton botonmiperfil = new MyHomeButton("Mi perfil", "icon/usuario.png");
		GridBagConstraints gbc_botonmiperfil = new GridBagConstraints();
		gbc_botonmiperfil.insets = new Insets(0, 0, 0, 5);
		gbc_botonmiperfil.gridx = 1;
		gbc_botonmiperfil.gridy = 0;
		panel_1.add(botonmiperfil, gbc_botonmiperfil);
//		botonmiperfil.addActionListener(e->{
//			padre.nuevoPanel(new PanelVerParticipantes(padre,1,"Competencia Uno"));
//		});
		
		
		MyHomeButton botoncerrarsesion = new MyHomeButton("Cerrar sesión", "icon/salir.png");
		GridBagConstraints gbc_botoncerrarsesion = new GridBagConstraints();
		gbc_botoncerrarsesion.gridx = 2;
		gbc_botoncerrarsesion.gridy = 0;
		panel_1.add(botoncerrarsesion, gbc_botoncerrarsesion);
		
		botoncerrarsesion.addActionListener(e->{
			System.exit(0);
		});
	}

}
