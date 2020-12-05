package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dtos.VerInterfazCompetenciaDTO;
import gui.Gui;
import gui.MyJComboBox;
import gui.MyJTable;
import gui.MyJTextField;
import gui.MyTitle;
import gui.PanelPersonalizado;

public class PanelMisCompetencias2 extends PanelPersonalizado {

	PanelMisCompetencias2TM tablemodel;	
	
	
	public PanelMisCompetencias2() {
		
		this.setPreferredSize(new Dimension(700, 734));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {80, 46, 142, 187, 137, 46, 80};
		gridBagLayout.rowHeights = new int[] {30, 187, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		MyTitle myTitle = new MyTitle("Mis Competencias");
		GridBagConstraints gbc_myTitle = new GridBagConstraints();
		gbc_myTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_myTitle.gridwidth = 3;
		gbc_myTitle.insets = new Insets(0, 0, 5, 0);
		gbc_myTitle.gridx = 2;
		gbc_myTitle.gridy = 0;
		add(myTitle, gbc_myTitle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		panel.setBounds(new Rectangle(30, 50, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 30, 30};
		gbl_panel.rowHeights = new int[] {20, 30, 30, 30, 30};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Nombre de la competencia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		MyJTextField myJTextField = new MyJTextField("Ingrese uno...");
		GridBagConstraints gbc_myJTextField = new GridBagConstraints();
		gbc_myJTextField.insets = new Insets(5, 5, 5, 5);
		gbc_myJTextField.gridwidth = 2;
		gbc_myJTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJTextField.gridx = 1;
		gbc_myJTextField.gridy = 0;
		panel.add(myJTextField, gbc_myJTextField);
		
		JLabel label_2 = new JLabel("Deporte");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(10, 5, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		MyJComboBox myJComboBox = new MyJComboBox(new String[] {"xd","xd2"});
		GridBagConstraints gbc_myJComboBox = new GridBagConstraints();
		gbc_myJComboBox.gridwidth = 2;
		gbc_myJComboBox.insets = new Insets(10, 5, 5, 5);
		gbc_myJComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJComboBox.gridx = 1;
		gbc_myJComboBox.gridy = 1;
		panel.add(myJComboBox, gbc_myJComboBox);
		
		JLabel label = new JLabel("Modalidad");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(10, 5, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);
		
		MyJComboBox myJComboBox_1 = new MyJComboBox(new String[] {"Liga", "Eliminatoria Simple", "Eliminatoria Doble" });
		GridBagConstraints gbc_myJComboBox_1 = new GridBagConstraints();
		gbc_myJComboBox_1.gridwidth = 2;
		gbc_myJComboBox_1.insets = new Insets(10, 5, 5, 5);
		gbc_myJComboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJComboBox_1.gridx = 1;
		gbc_myJComboBox_1.gridy = 2;
		panel.add(myJComboBox_1, gbc_myJComboBox_1);
		
		JLabel label_1 = new JLabel("Estado");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(10, 5, 5, 10);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		panel.add(label_1, gbc_label_1);
		
		MyJComboBox myJComboBox_2 = new MyJComboBox(new String[] {"Creada","Planificada","En disputa", "Finalizada"});
		GridBagConstraints gbc_myJComboBox_2 = new GridBagConstraints();
		gbc_myJComboBox_2.insets = new Insets(10, 5, 5, 5);
		gbc_myJComboBox_2.gridwidth = 2;
		gbc_myJComboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_myJComboBox_2.gridx = 1;
		gbc_myJComboBox_2.gridy = 3;
		panel.add(myJComboBox_2, gbc_myJComboBox_2);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setIcon(Gui.emoji("icon/lupa.png", 24, 24, true));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 4;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(5,5, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		List<VerInterfazCompetenciaDTO> lista = new ArrayList<VerInterfazCompetenciaDTO>();
		lista.add(new VerInterfazCompetenciaDTO(1,"xd","xd","xd","xd"));
		tablemodel = new PanelMisCompetencias2TM(lista);
		
		MyJTable myJTable = new MyJTable(tablemodel);
		myJTable.setJTableColumnsWidth(36,14,30,14,6);
		
		scrollPane.setViewportView(myJTable);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("    Nueva competencia");
		btnNewButton_1.setIcon(Gui.emoji("icon/mas_negro.png", 24, 24, true));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 3;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}

}
