package paneles;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import dtos.ParticipanteDTO;
import gui.Gui;

public class PanelVerParticipantesTM extends AbstractTableModel {


	private static final long serialVersionUID = 1L;


	private Object[][] data;
	private String[] columnNames = {"Nombre del participante", "Correo electrónico", "", ""};
	private List<ParticipanteDTO> dtos;
	
	private int tam;
	private int rowsperpage =10;
	private int totalpages;
	private int actualpage;
	
	
	
	
	public int getActualpage() {
		return actualpage;
	}

	public int getRowsperpage() {
		return rowsperpage;
	}

	public int getTam() {
		return tam;
	}

	public PanelVerParticipantesTM() {
		super();
		this.actualpage=1;
		this.totalpages=1;
	}
	
	public PanelVerParticipantesTM(List<ParticipanteDTO> lista) {
		super();
		dtos=lista;

		tam=dtos.size();
		data= new Object[tam][4];
				
		for(int i=0; i<tam; i++) {
			data[i][0]=dtos.get(i).getNombre();
			data[i][1]=dtos.get(i).getEmail();
			data[i][2]=Gui.emoji("icon/lapiz.png", 18, 18, false);
			data[i][3]=Gui.emoji("icon/basura.png", 18, 18, false);
		}

		this.totalpages= (int) Math.ceil((double) tam/ rowsperpage);
		this.actualpage=1;
		
	}

	@Override
	public int getRowCount() {
		return tam>0?Math.min(rowsperpage, tam-(actualpage-1)*rowsperpage):0;
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
		return data[rowIndex+(actualpage-1)*rowsperpage][columnIndex];
	}

	@Override
	public Class getColumnClass(int c) { 
		
		if(c<=1) {return String.class;}
		else {return ImageIcon.class;}

	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void setActualPage(int i) {
		actualpage=i;
		this.fireTableDataChanged();
	}

	public int getTotalpages() {
		return totalpages;
	}
	

}



