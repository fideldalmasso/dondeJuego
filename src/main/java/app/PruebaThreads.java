package app;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.TableModel;

import gui.Gui;
import gui.MyPack;
import gui.MyTitle;
import paneles.LugarRealizacionTM;

public class PruebaThreads extends JFrame{

	TableModel tablemodel;
	JTable table;
	MyPack<JScrollPane> pack = new MyPack<JScrollPane>("Tabla",true);
	
	private class Tarea extends SwingWorker<TableModel,String>{
		TableModel t;
		@Override
		protected TableModel doInBackground() throws Exception {
			t= new LugarRealizacionTM(-1);
			return t;
		}
		
		@Override
		protected void done() {
			pack.error().cargando=false;
			table.setModel(t);
			pack.setEnabled(true);
			
			
		}
		
	}
	
	public PruebaThreads() {
		super();
		this.setMinimumSize(new Dimension(600,600));
		JPanel panel = new JPanel(new GridBagLayout());
		this.setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tablemodel = new LugarRealizacionTM();
		table=new JTable(tablemodel);
		JScrollPane jsp = new JScrollPane(table);
		pack.setComponent(jsp);
		Gui.colocar(0, 0, 1, 1, 1, 1, 0, 0, Gui.BOTH, Gui.CENTER, panel, pack.full());
		Tarea t = new Tarea();
		t.execute();
		
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PruebaThreads().setVisible(true);
            }
        });
	}

}



