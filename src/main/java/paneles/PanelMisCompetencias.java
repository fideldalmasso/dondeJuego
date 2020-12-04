package paneles;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import daos.DeporteDAO;
import dominio.Deporte;
import gui.MyJComboBox;
import gui.MyJTextField;
import gui.MyPack;
import gui.MyTitle;
import gui.PanelPersonalizado;

public class PanelMisCompetencias extends PanelPersonalizado{

	private static final long serialVersionUID = 1L;
	
	private MyTitle titulo = new MyTitle("Mis Competencias"); 
	private MyPack<MyJTextField> nombre = new MyPack<MyJTextField>("Nombre de la competencia");
	private MyPack<MyJComboBox> deporte = new MyPack<MyJComboBox>("Deporte",true);
	private MyPack<MyJComboBox> modalidad = new MyPack<MyJComboBox>("Modalidad");
	private MyPack<MyJComboBox> estado = new MyPack<MyJComboBox>("Estado");
	
	private JButton botonbuscar = new JButton("Buscar");
	
	
	private SwingWorker<String[], Void> trabajador1;
	
	public PanelMisCompetencias() {
		
		this.setPreferredSize(new Dimension(780, 734));
		this.setLayout(new GridBagLayout());
		
		{
			nombre.setComponent(new MyJTextField("Ingrese uno..."));
		}
		{
			deporte.setComponent(new MyJComboBox(new String[] {""}));
			
			trabajador1 = new SwingWorker<String[], Void>(){
				private String[] t;
				@Override
				protected String[] doInBackground() throws Exception {
					List<Deporte> listaDeportes = new DeporteDAO().getAll();
					t= listaDeportes.stream().map(d->d.getNombre()).collect(Collectors.toList()).toArray(new String[0]);
					return t;
				}
				@Override 
				protected void done() {
					deporte.component().setModel(new DefaultComboBoxModel<String>(t));
					deporte.stopLoading();
				}
				
			};
		}
		{
			String listaModalidades[] = {"Liga","Eliminatoria simple", "Eliminatoria doble"};
			modalidad.setComponent(new MyJComboBox(listaModalidades));
		}
		{
			String listaEstados[] = {"CREADA","PLANIFICADA","ENDISPUTA","FINALIZADA"};
			modalidad.setComponent(new MyJComboBox(listaEstados));
		}
		
		
		
		
		
		
	}
}
