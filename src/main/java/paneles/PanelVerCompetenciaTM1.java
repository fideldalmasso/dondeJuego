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

public class PanelVerCompetenciaTM1 extends AbstractTableModel {


	private static final long serialVersionUID = 1L;

	private Object[][] data2;
	private String[] columnNames = {"Nombre del equipo / participante","Correo electrónico"};
	private VerCompetenciaDTO dto;
	private Integer tam;

	
	public PanelVerCompetenciaTM1() {
		super();
		tam=0;
		return;
	}
	
	public PanelVerCompetenciaTM1(VerCompetenciaDTO dto) {
		super();
		this.dto=dto;
		if(dto.getParticipantes()==null || dto.getParticipantes().size()==0) {
			tam=0;
			Gui.imprimir("la lista de participantes es nula o esta vacia");
			return;
		}
		tam=dto.getParticipantes().size();
		data2= new Object[tam][2];
				
		for(int i=0; i<tam; i++) {
			data2[i][0]=dto.getParticipantes().get(i).getNombre();
			data2[i][1]=dto.getParticipantes().get(i).getEmail();
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
		return col==0 || col==2;
	}
	

	
	
	
}



