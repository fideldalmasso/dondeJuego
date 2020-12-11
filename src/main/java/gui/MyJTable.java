package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MyJTable extends JTable {

	
	public void ordenar() {
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sorter);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
	}
	
	public MyJTable() {
		// TODO Auto-generated constructor stub
	}

	public MyJTable(TableModel dm) {
		super(dm);
//		tablalugares.setFont(new Font("Comic Sans MS",Font.PLAIN,12));
//		tablalugares.getTableHeader().setFont(new Font("Comic Sans MS",Font.PLAIN,12));
		
		this.setIgnoreRepaint(false);
		this.setRowHeight(20);
		this.getTableHeader().setReorderingAllowed(false);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	}

	public MyJTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	public MyJTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	public MyJTable(Vector<? extends Vector> rowData, Vector<?> columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public MyJTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public MyJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		// TODO Auto-generated constructor stub
	}
	
	public void setColumnWidths(int... width) {
		
		for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
			setColumnWidth(i, width[i]);
		}
	}
	
	public void setColumnWidth(int index, int width) {
		this.getColumnModel().getColumn(index).setPreferredWidth(width);
	}
	
	//https://www.codejava.net/java-se/swing/setting-column-width-and-row-height-for-jtable
	public  void setJTableColumnsWidth(double... percentages) {
		
		int tablePreferredWidth= this.preferredViewportSize.width;
//		Gui.imprimir("Preffered width de la tabla: "+tablePreferredWidth);
	    double total = 0;
	    for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
	        total += percentages[i];
	    }
	 
	    for (int i = 0; i < this.getColumnModel().getColumnCount(); i++) {
	        TableColumn column = this.getColumnModel().getColumn(i);
	        column.setPreferredWidth((int)
	                (tablePreferredWidth * (percentages[i] / total)));
	    }
	}

	
	public void update() {
		((AbstractTableModel)this.getModel()).fireTableDataChanged();
		this.repaint();
	}

}
