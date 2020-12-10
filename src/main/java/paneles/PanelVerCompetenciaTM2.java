package paneles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dominio.LugarRealizacion;
import dominio.Pair;
import dtos.CompetenciaDTO;
import dtos.VerCompetenciaDTO;
import gestores.GestorLugarRealizacion;
import gui.Gui;

public class PanelVerCompetenciaTM2 extends AbstractTableModel {


	private static final long serialVersionUID = 1L;

	private Object[][] data2;
	private String[] columnNames = {"Participante A","Participante B","Fecha","Lugar"};
	private VerCompetenciaDTO dto;
	private Integer tam;

	
	public PanelVerCompetenciaTM2() {
		super();
		tam=0;
		return;
	}
	
	public PanelVerCompetenciaTM2(VerCompetenciaDTO dto) {
		super();
		this.dto=dto;

		tam=dto.getProximosEncuetros().size();
		data2= new Object[tam][4];
				
		for(int i=0; i<tam; i++) {
			data2[i][0]=dto.getProximosEncuetros().get(i).getNombreParticipanteA();
			data2[i][1]=dto.getProximosEncuetros().get(i).getNombreParticipanteB();
			data2[i][2]=dto.getProximosEncuetros().get(i).getFecha();
			data2[i][3]=dto.getProximosEncuetros().get(i).getLugar();
			
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
        return String.class;
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	

	
	
	
}



