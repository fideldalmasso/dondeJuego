package gui;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.table.TableModel;

import daos.DeporteDAO;
import dominio.Deporte;
import dominio.Mensaje;
import dtos.CompetenciaDTO;
import gestores.GestorCompetencia;

public class PanelAltaCompetencia extends PanelPersonalizado {

	public enum errores{EXITO,NOMBRE,DEPORTE,LUGAR,MODALIDAD,SISTEMAPUNTUACION,REGLAMENTO,USUARIO,PUNTOSPOREMPATE,CANTIDADMAXIMASETS};
	
	
	private EnumMap<errores, MyPack> mapacomponentes= new EnumMap<PanelAltaCompetencia.errores, MyPack>(errores.class);
	
	
	private static final long serialVersionUID = 1L;
	private MyTitle titulo = new MyTitle("Crear competencia"); 
	private MyPack<MyJTextField> nombre = new MyPack<MyJTextField>("Nombre");
	private MyPack<MyJComboBox> deporte = new MyPack<MyJComboBox>("Deporte",true);
	private MyPack<JScrollPane> lugar = new MyPack<JScrollPane>("Lugar(Disponibilidad)",true);
	private MyPack<MyJComboBox> modalidad = new MyPack<MyJComboBox>("Modalidad");
	private MyPack<MyJComboBox> formapuntuacion = new MyPack<MyJComboBox>("Forma de puntuación");
	
	private MyPack<JCheckBox> empatepermitido = new MyPack<JCheckBox>("Empate permitido");
	private MyPack<JSpinner> puntosporpartidoganado = new MyPack<JSpinner>("Puntos por partido ganado");
	private MyPack<JSpinner> puntosporempate = new MyPack<JSpinner>("Puntos por empate");
	private MyPack<JSpinner> puntosporpresentarse = new MyPack<JSpinner>("Puntos por presentarse");
	private MyPack<JSpinner> cantidadmaximadesets = new MyPack<JSpinner>("Cantidad máxima de sets");
	private MyPack<JSpinner> puntosporabandono = new MyPack<JSpinner>("Puntos por abandono");
	
	private MyPack<MyJTextArea> reglamento = new MyPack<MyJTextArea>("Reglamento");
	
	private MyJTable tablalugares;
	private LugarRealizacionTM tablemodel;
	
	
	private JPanel panelBotones= new JPanel(new GridBagLayout());
	private JButton botonaceptar = new JButton("Aceptar");
	private JButton botoncancelar = new JButton("Cancelar");

	

	private CompetenciaDTO dto;
	private List<Deporte> listaDeportes;
	
	private SwingWorker<String[], Void> trabajador1;
	private SwingWorker<LugarRealizacionTM, Void> trabajador2;
	
	
	public PanelAltaCompetencia() {
		
		
		
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
					deporte.component().setModel(new DefaultComboBoxModel<String>(t));
					deporte.stopLoading();
					trabajador2.execute();
				}
				
			};
			
		}
		{
			//[width=165,height=20]
			tablemodel = new LugarRealizacionTM();
			tablalugares = new MyJTable(tablemodel);
			tablalugares.setColumnWidths(20,290,100);
			//tablalugares.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
			lugar.setComponent(new JScrollPane(tablalugares));
			mapacomponentes.put(errores.LUGAR, lugar);
			
			trabajador2 = new SwingWorker<LugarRealizacionTM, Void>(){
				private LugarRealizacionTM t;
				@Override
				protected LugarRealizacionTM doInBackground() throws Exception {
					t= new LugarRealizacionTM(getIdDeporteSeleccionado());
					return t;
				}
				@Override 
				protected void done() {
					tablemodel=t;
					tablalugares.setModel(t);
					tablalugares.setColumnWidths(20,290,100);
					lugar.stopLoading();
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
			botonaceptar.addActionListener(e->{
				
				if(tablalugares.isEditing()) {
					if(Gui.DEBUG) System.out.println("se tuvo que detener la tabla");
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
				
				this.validar(new GestorCompetencia().crearCompetencia(dto));
			});
			
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
			
		}
		{
			
			Gui.colocar(0,0,3,1,0,0,0,0,Gui.NONE,Gui.CENTER,this, titulo);

			Gui.colocar(0,1,1,1,0,0,0,0,Gui.NONE,Gui.WEST,this, nombre.label());
			Gui.colocar(1,1,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,this, nombre.semi2());
			
			Gui.colocar(0,2,1,1,0,0,0,0,Gui.NONE,Gui.WEST,this, deporte.label());
		
			
			Gui.colocar(1,2,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,this, deporte.semi2());
			
			Gui.colocar(0,3,1,1,0,0,0,0,Gui.NONE,Gui.NORTHWEST,this, lugar.label());
			Gui.colocar(1,3,2,1,1,1,0,0,Gui.BOTH,Gui.WEST,this, lugar.semi2());
			
			Gui.colocar(0,4,1,1,0,0,0,0,Gui.NONE,Gui.WEST,this, modalidad.label());
			Gui.colocar(1,4,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,this, modalidad.semi2());
			
			Gui.colocar(0,5,1,1,0,0,0,0,Gui.NONE,Gui.WEST,this, formapuntuacion.label());
			Gui.colocar(1,5,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,this, formapuntuacion.semi2());
			
			
			
			Gui.colocar(1,6,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, puntosporpartidoganado.full());
			
			Gui.colocar(0,7,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, empatepermitido.semi1());
			Gui.colocar(1,7,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, puntosporempate.full());
			Gui.colocar(1,8,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, puntosporpresentarse.full());
			
			Gui.colocar(2,6,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, cantidadmaximadesets.full());
			Gui.colocar(2,7,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, puntosporabandono.full());
			
			
			Gui.colocar(0,9,1,1,0,0,0,0,Gui.NONE,Gui.NORTHWEST,this, reglamento.label());
			Gui.colocar(1,9,2,1,1,1,0,0,Gui.BOTH,Gui.WEST,this, reglamento.semi2());
			
			Gui.colocar(2,10,1,1,0,0,0,0,Gui.NONE,Gui.CENTER,this, panelBotones);

			
		}
		trabajador1.execute();
		
	}
	
	private void validar(Mensaje<errores> m) {
		if(m.getMensaje().containsKey(errores.EXITO)) {
			botonaceptar.setToolTipText("Éxito");
			return;
		}
		for(Map.Entry<errores, String> i : m.getMensaje().entrySet()) {
			
			if(mapacomponentes.get(i.getKey())!=null) {
				mapacomponentes
				.get(i.getKey())
				.showError(i.getValue());				
			}
			else {if(Gui.DEBUG)System.out.println("El enum "+ i.getKey() + " no tiene ningun componente asociado");}
			
			
		}
	}
	
	
	private Integer getIdDeporteSeleccionado() {
		return listaDeportes.get(deporte.component().getSelectedIndex()).getId();
	}

	
	
}
