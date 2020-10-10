package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dominio.LugarRealizacion;
import dominio2.Deporte;
import dominio2.Lugarrealizacion;
import gestores.GestorLugarRealizacion;

public class LugarRealizacionTM extends AbstractTableModel {

	GestorLugarRealizacion gestor;

	private Object[][] data2;
	private List<LugarRealizacion> data;
	private String[] columnNames = {"","Lugar","Disponibilidad"};
	
	public LugarRealizacionTM() {
		gestor = new GestorLugarRealizacion();
		recargarTabla();
		
	}
	
	public void recargarTabla() {
		//this.data = new ArrayList<LugarRealizacion>();
		this.data = gestor.getAllLugarRealizacion();
		this.data2 = new Object[data.size()][3];
		
		for(int i=0; i<data.size(); i++) {
			data2[i][0]=false;
			data2[i][1]=data.get(i).getNombre();
			data2[i][2]=0;
		}
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	
	public LugarRealizacion getObject(int row) {
		return data.get(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data2[rowIndex][columnIndex];
//		LugarRealizacion temp = data.get(rowIndex);
//		switch(columnIndex) {
//		case 0:
//			return "";
//		case 1:
//			return temp.getNombre();
//		case 2:
//			return "-";
//		}
//		return null;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		data2[row][col]=value;
        fireTableCellUpdated(row, col);
    }
	
	@Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return col==0 || col==2;
	}
	
	public void setData(List<LugarRealizacion>lista ) {
		this.data = lista;
	}

}



