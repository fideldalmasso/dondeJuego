package paneles;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import dtos.VerInterfazCompetenciaDTO;
import gui.Gui;

public class PanelMisCompetenciasTM extends AbstractTableModel {


	private static final long serialVersionUID = 1L;


	private Object[][] data;
	private String[] columnNames = {"Nombre de la competencia", "Deporte", "Modalidad", "Estado", "Ver"};
	private List<VerInterfazCompetenciaDTO> dtos;
	
	private int tam;
	private int rowsperpage =3;
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

	public PanelMisCompetenciasTM() {
		super();
		this.actualpage=1;
		this.totalpages=1;
	}
	
	public PanelMisCompetenciasTM(List<VerInterfazCompetenciaDTO> lista) {
		super();
		dtos=lista;

		tam=dtos.size();
		data= new Object[tam][6];
				
		for(int i=0; i<tam; i++) {
			data[i][0]=dtos.get(i).getNombre();
			data[i][1]=dtos.get(i).getDeporte();
			data[i][2]=dtos.get(i).getModalidad();
			data[i][3]=dtos.get(i).getEstado();
			data[i][4]=Gui.emoji("icon/ver.png", 24, 24, false);
			data[i][5]=dtos.get(i).getIdCompetencia();
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
		
		if(c<4) {return String.class;}
		else if(c==4) {return ImageIcon.class;}
		else return int.class;
		
			
//		return c<4?String.class:ImageIcon.class; 

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



