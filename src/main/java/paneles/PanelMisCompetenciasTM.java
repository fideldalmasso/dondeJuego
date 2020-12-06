package paneles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import dominio.LugarRealizacion;
import dominio.Pair;
import dtos.VerInterfazCompetenciaDTO;
import gestores.GestorLugarRealizacion;
import gui.Gui;

public class PanelMisCompetenciasTM extends AbstractTableModel {


	private static final long serialVersionUID = 1L;

	GestorLugarRealizacion gestor;

	private Object[][] data;
	private String[] columnNames = {"Nombre de la competencia", "Deporte", "Modalidad", "Estado", "Ver"};
	private List<VerInterfazCompetenciaDTO> dtos;
	private int tam;

	public int getTam() {
		return tam;
	}

	public PanelMisCompetenciasTM() {
		super();
	}
	
	public PanelMisCompetenciasTM(List<VerInterfazCompetenciaDTO> lista) {
		super();
		dtos=lista;

		tam=dtos.size();
		data= new Object[tam][5];
				
		for(int i=0; i<tam; i++) {
			data[i][0]=dtos.get(i).getNombre();
			data[i][1]=dtos.get(i).getDeporte();
			data[i][2]=dtos.get(i).getModalidad();
			data[i][3]=dtos.get(i).getEstado();
			data[i][4]=Gui.emoji("icon/ver.png", 24, 24, false);
		}

	}

	@Override
	public int getRowCount() {
		return tam;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public Class getColumnClass(int c) { 
		return c<4?String.class:ImageIcon.class; 

	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}



