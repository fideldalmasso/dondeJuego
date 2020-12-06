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

public class PanelMisCompetencias2TM extends AbstractTableModel {


	private static final long serialVersionUID = 1L;

	GestorLugarRealizacion gestor;

	private Object[][] data2;
	private String[] columnNames = {"Nombre de la competencia", "Deporte", "Modalidad", "Estado", "Ver"};
	private List<VerInterfazCompetenciaDTO> data3;
	private int tam;

	public PanelMisCompetencias2TM(List<VerInterfazCompetenciaDTO> lista) {
		super();
		data3=lista;

		tam=data3.size();
		data2= new Object[tam][5];
				
		for(int i=0; i<tam; i++) {
			data2[i][0]=data3.get(i).getNombre();
			data2[i][1]=data3.get(i).getDeporte();
			data2[i][2]=data3.get(i).getModalidad();
			data2[i][3]=data3.get(i).getEstado();
			data2[i][4]=Gui.emoji("icon/ver.png", 24, 24, false);
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
		return data2[rowIndex][columnIndex];
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



