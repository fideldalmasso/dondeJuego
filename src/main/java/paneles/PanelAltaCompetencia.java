package paneles;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;

import app.App;
import daos.DeporteDAO;
import dominio.Deporte;
import dominio.Mensaje2;
import dtos.CompetenciaDTO;
import gestores.GestorCompetencia;
import gui.*;

public class PanelAltaCompetencia extends PanelPersonalizado {

	public enum errores{EXITO,NOMBRE,DEPORTE,LUGAR,MODALIDAD,SISTEMAPUNTUACION,REGLAMENTO,USUARIO,PUNTOSPOREMPATE,CANTIDADMAXIMASETS};
	
	
	private EnumMap<errores, MyPack> mapacomponentes= new EnumMap<PanelAltaCompetencia.errores, MyPack>(errores.class);
	
	
	public static final long serialVersionUID = 1L;
	public MyTitle titulo = new MyTitle("Crear competencia"); 
	public MyPack<MyJTextField> nombre = new MyPack<MyJTextField>("Nombre");
	public MyPack<JScrollPane> lugar = new MyPack<JScrollPane>("Lugar(Disponibilidad)",true);
	public MyPack<MyJComboBox> deporte = new MyPack<MyJComboBox>("Deporte",true);
	public MyPack<MyJComboBox> modalidad = new MyPack<MyJComboBox>("Modalidad");
	public MyPack<MyJComboBox> formapuntuacion = new MyPack<MyJComboBox>("Forma de puntuación");

	public MyPack<JCheckBox> empatepermitido = new MyPack<JCheckBox>("Empate permitido");
	public MyPack<JSpinner> puntosporpartidoganado = new MyPack<JSpinner>("Puntos por partido ganado");
	public MyPack<JSpinner> puntosporempate = new MyPack<JSpinner>("Puntos por empate");
	public MyPack<JSpinner> puntosporpresentarse = new MyPack<JSpinner>("Puntos por presentarse");
	public MyPack<JSpinner> cantidadmaximadesets = new MyPack<JSpinner>("Cantidad máxima de sets");
	public MyPack<JSpinner> puntosporabandono = new MyPack<JSpinner>("Puntos por abandono");
	
	private MyPack<MyJTextArea> reglamento = new MyPack<MyJTextArea>("Reglamento");
	
	private MyJTable tablalugares;
	private PanelAltaCompetenciaTM tablemodel;
	
	
	private JPanel panelBotones= new JPanel(new GridBagLayout());
	public JButton botonaceptar = new JButton("Aceptar");
	public JButton botoncancelar = new JButton("Cancelar");

	

	private CompetenciaDTO dto;
	private List<Deporte> listaDeportes;
	
	private SwingWorker<String[], Void> trabajador1;
	private SwingWorker<PanelAltaCompetenciaTM, Void> trabajador2;
	
	private App padre;
	
	JPanel panel1;
	JLayeredPane panel2;
	
	
	public PanelAltaCompetencia(App padre) {
		
		panel1 = new JPanel(new GridBagLayout());
		panel2 = new JLayeredPane();
		this.padre = padre;
		this.setPreferredSize(new Dimension(780, 734));
//		this.setBackground(new Color(250, 216, 214));
		this.setLayout(new GridBagLayout());
		
		{
			nombre.setComponent(new MyJTextField("Ingrese uno..."));
			mapacomponentes.put(errores.NOMBRE, nombre);
			
		}
		{
			deporte.setComponent(new MyJComboBox(new String[] {""}));
			mapacomponentes.put(errores.DEPORTE, deporte);
			
			trabajador1 = new SwingWorker<String[], Void>(){
				private String[] t;
				@Override
				protected String[] doInBackground() throws Exception {
					listaDeportes= new DeporteDAO().getAll();
					t= listaDeportes.stream().map(d->d.getNombre()).collect(Collectors.toList()).toArray(new String[0]);
					return t;
				}
				@Override 
				protected void done() {
					deporte.component().setModel(new DefaultComboBoxModel<String>(t!=null?t:new String[] {" "}));
					deporte.stopLoading();
					trabajador2.execute();
				}
				
			};
			
			
		}
		{
			//[width=165,height=20]
			tablemodel = new PanelAltaCompetenciaTM();
			tablalugares = new MyJTable(tablemodel);
			tablalugares.setColumnWidths(20,290,100);
			//tablalugares.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
			lugar.setComponent(new JScrollPane(tablalugares));
			mapacomponentes.put(errores.LUGAR, lugar);
			
			trabajador2 = new SwingWorker<PanelAltaCompetenciaTM, Void>(){
				private PanelAltaCompetenciaTM t;
				@Override
				protected PanelAltaCompetenciaTM doInBackground() throws Exception {
					t= new PanelAltaCompetenciaTM(getIdDeporteSeleccionado());
					return t;
				}
				@Override 
				protected void done() {
					tablemodel=t;
					if(t!=null) {
						tablalugares.setModel(t);
						tablalugares.setColumnWidths(20,290,100);
						lugar.stopLoading();
					}
					else {
						Gui.imprimir("Hubo un error cargando la tabla desde la db");
					}
				}
				
			};
		
		}
		{
			String listaModalidades[] = {"Liga","Eliminatoria simple", "Eliminatoria doble"};
			modalidad.setComponent(new MyJComboBox(listaModalidades));
			mapacomponentes.put(errores.MODALIDAD, modalidad);
		}
		{
			String listaFormasPuntuacion[] = {"Sets", "Puntuación", "Resultado final"};
			formapuntuacion.setComponent(new MyJComboBox(listaFormasPuntuacion));
			mapacomponentes.put(errores.SISTEMAPUNTUACION, formapuntuacion);
		}
		{
			empatepermitido.setComponent(new JCheckBox());
			
			puntosporpartidoganado.setComponent(new JSpinner(new SpinnerNumberModel(3,1,100,1)));
			       puntosporempate.setComponent(new JSpinner(new SpinnerNumberModel(1,0,100,1)));
			  puntosporpresentarse.setComponent(new JSpinner(new SpinnerNumberModel(0,0,100,1)));
			  cantidadmaximadesets.setComponent(new JSpinner(new SpinnerNumberModel(3,1,10,2)));
			     puntosporabandono.setComponent(new JSpinner(new SpinnerNumberModel(3,0,100,1)));
			     
			mapacomponentes.put(errores.PUNTOSPOREMPATE, puntosporempate);
			puntosporempate.setEnabled(false);
			
		}
		{
			reglamento.setComponent(new MyJTextArea("(Opcional)Ingrese uno..."));
			reglamento.error().setVisible(false);
			mapacomponentes.put(errores.REGLAMENTO, reglamento);
		}
		{
			Gui.colocar2(0, 0, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, insetvacio, panelBotones, botoncancelar);
			Gui.colocar2(1, 0, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, insetvacio, panelBotones, new JLabel("    "));
			Gui.colocar2(2, 0, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, insetvacio, panelBotones, botonaceptar);
			botonaceptar.setEnabled(false);
//			botonaceptar.addActionListener(e->{
//				
//				if(tablalugares.isEditing()) {
//					Gui.imprimir("se tuvo que detener la tabla");
//					tablalugares.getCellEditor().stopCellEditing();
//				}
//				
//				if(!nombre.component().hasChanged()) nombre.component().setText(null);
//				if(!reglamento.component().hasChanged()) reglamento.component().setText(null);
//				
//				dto=new CompetenciaDTO();
//				dto.setNombre(nombre.component().getText());
//				dto.setDeporte(listaDeportes.get(deporte.component().getSelectedIndex()).getId());
//				dto.setLugares(tablemodel.getSelected());
//				dto.setModalidad(modalidad.component().getSelectedItem());
//				dto.setReglamento(reglamento.component().getText());
//				dto.setPermiteEmpate(empatepermitido.component().isSelected());
//				dto.setPuntosPorPresentarse((Integer)puntosporpresentarse.component().getValue());
//				dto.setPuntosPorGanar((Integer)puntosporpartidoganado.component().getValue());
//				dto.setPuntosPorEmpate((Integer)puntosporempate.component().getValue());
//				dto.setSistemaPuntuacion(formapuntuacion.component().getSelectedItem());
//				dto.setPuntosPorAbandono((Integer)puntosporabandono.component().getValue());
//				dto.setCantidadMaximaSets((Integer)cantidadmaximadesets.component().getValue());
//				
//				this.validar(new GestorCompetencia().crearCompetencia(dto));
//			});
			
		}
		
		{//enable y disable automaticos
			
			modalidad.component().addActionListener(e->{
				Boolean value = modalidad.component().getSelectedItem().equals("Liga");
				puntosporpartidoganado.setEnabled(value);
				puntosporpresentarse.setEnabled(value);
				
				empatepermitido.component().setSelected(false);
				empatepermitido.setEnabled(value);
				
				if(!value) {
					puntosporempate.setEnabled(value);
				}
				
			});
			
			formapuntuacion.component().addActionListener(e->{
				String value = (String)formapuntuacion.component().getSelectedItem();
				
				cantidadmaximadesets.setEnabled(value.equals("Sets"));
				puntosporabandono.setEnabled(value.equals("Puntuación"));
			});

			empatepermitido.component().addActionListener(e->{
				puntosporempate.setEnabled(empatepermitido.component().isSelected());
			});
						
			nombre.component().addChangeListener(e->{
				botonaceptar.setEnabled(nombre.component().hasChanged() && nombre.component().getText()!=null);	
			});
			
			deporte.component().addActionListener(e->{
				
				tablemodel.recargarTabla(getIdDeporteSeleccionado());
				tablalugares.update();
			});
			
//			botoncancelar.addActionListener(e->{
//				padre.volverAtras();
//			});
			
		}
		{
			
			Gui.colocar(0,0,3,1,0,0,0,0,Gui.NONE,Gui.CENTER,panel1, titulo);

			Gui.colocar(0,1,1,1,0,0,0,0,Gui.NONE,Gui.WEST,panel1, nombre.label());
			Gui.colocar(1,1,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,panel1, nombre.semi2());
			
			Gui.colocar(0,2,1,1,0,0,0,0,Gui.NONE,Gui.WEST,panel1, deporte.label());
		
			
			Gui.colocar(1,2,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,panel1, deporte.semi2());
			
			Gui.colocar(0,3,1,1,0,0,0,0,Gui.NONE,Gui.NORTHWEST,panel1, lugar.label());
			Gui.colocar(1,3,2,1,1,1,0,0,Gui.BOTH,Gui.WEST,panel1, lugar.semi2());
			
			Gui.colocar(0,4,1,1,0,0,0,0,Gui.NONE,Gui.WEST,panel1, modalidad.label());
			Gui.colocar(1,4,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,panel1, modalidad.semi2());
			
			Gui.colocar(0,5,1,1,0,0,0,0,Gui.NONE,Gui.WEST,panel1, formapuntuacion.label());
			Gui.colocar(1,5,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,panel1, formapuntuacion.semi2());
			
			
			
			Gui.colocar(1,6,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,panel1, puntosporpartidoganado.full());
			
			Gui.colocar(0,7,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,panel1, empatepermitido.semi1());
			Gui.colocar(1,7,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,panel1, puntosporempate.full());
			Gui.colocar(1,8,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,panel1, puntosporpresentarse.full());
			
			Gui.colocar(2,6,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,panel1, cantidadmaximadesets.full());
			Gui.colocar(2,7,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,panel1, puntosporabandono.full());
			
			
			Gui.colocar(0,9,1,1,0,0,0,0,Gui.NONE,Gui.NORTHWEST,panel1, reglamento.label());
			Gui.colocar(1,9,2,1,1,1,0,0,Gui.BOTH,Gui.WEST,panel1, reglamento.semi2());
			
			Gui.colocar(2,10,1,1,0,0,0,0,Gui.NONE,Gui.CENTER,panel1, panelBotones);

			
			Gui.colocar(1, 1, 1, 1, 1, 1, 0, 1, Gui.BOTH, Gui.CENTER, this, panel1);
			
		}
		trabajador1.execute();
		
	}
	
	private boolean validar(Mensaje2<errores> m) {
		if(m.getMensaje().containsKey(errores.EXITO)) {
//			botonaceptar.setToolTipText("Éxito");
				
			
			return true;
		}
		for(Map.Entry<errores, String> i : m.getMensaje().entrySet()) {
			
			if(mapacomponentes.get(i.getKey())!=null) {
				mapacomponentes
				.get(i.getKey())
				.showError(i.getValue());				
			}
			else {Gui.imprimir("El enum "+ i.getKey() + " no tiene ningun componente asociado");}
			
			
		}
		return false;
	}
	
	
	private Integer getIdDeporteSeleccionado() {
		return listaDeportes.get(deporte.component().getSelectedIndex()).getId();
	}

	
	public boolean agregarCompetencia() {
		
		if(tablalugares.isEditing()) {
			Gui.imprimir("se tuvo que detener la tabla");
			tablalugares.getCellEditor().stopCellEditing();
		}
		
		if(!nombre.component().hasChanged()) nombre.component().setText(null);
		if(!reglamento.component().hasChanged()) reglamento.component().setText(null);
		
		dto=new CompetenciaDTO();
		dto.setNombre(nombre.component().getText());
		dto.setDeporte(listaDeportes.get(deporte.component().getSelectedIndex()).getId());
		dto.setLugares(tablemodel.getSelected());
		dto.setModalidad(modalidad.component().getSelectedItem());
		dto.setReglamento(reglamento.component().getText());
		dto.setPermiteEmpate(empatepermitido.component().isSelected());
		dto.setPuntosPorPresentarse((Integer)puntosporpresentarse.component().getValue());
		dto.setPuntosPorGanar((Integer)puntosporpartidoganado.component().getValue());
		dto.setPuntosPorEmpate((Integer)puntosporempate.component().getValue());
		dto.setSistemaPuntuacion(formapuntuacion.component().getSelectedItem());
		dto.setPuntosPorAbandono((Integer)puntosporabandono.component().getValue());
		dto.setCantidadMaximaSets((Integer)cantidadmaximadesets.component().getValue());
		
		return validar(new GestorCompetencia().crearCompetencia(dto));
	}
	
	
	
	
	
}
