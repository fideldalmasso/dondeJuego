package paneles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dominio.LugarRealizacion;
import dominio.Pair;
import gestores.GestorLugarRealizacion;
import gui.Gui;

public class PanelAltaCompetenciaTM extends AbstractTableModel {


	private static final long serialVersionUID = 1L;

	GestorLugarRealizacion gestor;

	private Object[][] data2;
	private List<LugarRealizacion> data;
	private String[] columnNames = {"","Lugar","Disponibilidad"};
	

	
	public PanelAltaCompetenciaTM() {
		super();
		data = new ArrayList<LugarRealizacion>();
		return;
	}
	
	public PanelAltaCompetenciaTM(Integer idDeporte) {
		super();
		gestor = new GestorLugarRealizacion();
		recargarTabla(idDeporte);
		
	}
	
	public void recargarTabla(Integer idDeporte) {
		//this.data = new ArrayList<LugarRealizacion>();
		if(idDeporte==-1)
			this.data = gestor.getAllLugarRealizacion();
		else
			this.data = gestor.getAllLugarRealizacion(idDeporte);
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
	
	public List<Pair> getSelected() {
		List<Pair> lista = new ArrayList<Pair>();
		for (int i = 0; i < data.size(); i++) {
			if(((boolean)data2[i][0])==true)
				lista.add(new Pair(data.get(i).getId(),(Integer)data2[i][2]));
		}
		if(Gui.DEBUG)System.out.println(lista.toString());
		return lista;
	}

	
	
	
}



