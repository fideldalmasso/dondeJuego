package gui;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import daos.DeporteDAO;
import dominio.Mensaje;
import dtos.CompetenciaDTO;
import gestores.GestorCompetencia;

public class PanelAltaCompetencia2 extends PanelPersonalizado {

	public enum errores{EXITO,NOMBRE,DEPORTE,LUGAR,MODALIDAD,SISTEMAPUNTUACION,REGLAMENTO,USUARIO};
	
	
	private EnumMap<errores, MyPack> xd= new EnumMap<PanelAltaCompetencia2.errores, MyPack>(errores.class);
	
	
	private static final long serialVersionUID = 1L;
	private MyTitle titulo = new MyTitle("Crear competencia"); 
	private MyPack<MyJTextField> nombre = new MyPack<MyJTextField>("Nombre");
	private MyPack<MyJComboBox> deporte = new MyPack<MyJComboBox>("Deporte");
	private MyPack<JScrollPane> lugar = new MyPack<JScrollPane>("Lugar(Disponibilidad)");
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

	
	private DeporteDAO dao= new DeporteDAO();
	private GestorCompetencia gestor = new GestorCompetencia();
	private CompetenciaDTO dto;
	
	public PanelAltaCompetencia2() {
		
		
		
		this.setPreferredSize(new Dimension(780, 734));
//		this.setBackground(new Color(250, 216, 214));
		this.setLayout(new GridBagLayout());
		
		{
			nombre.setComponent(new MyJTextField("Ingrese uno..."));
			xd.put(errores.NOMBRE, nombre);
			
		}
		{
//			String listaDeportes[] = {"xd", "xd2"}; //TODO los deportes con nombres muy largos hacen fallar la gui
			String listaDeportes[] = dao.getAll().stream().map(d->d.getNombre()).collect(Collectors.toList()).toArray(new String[0]);
			deporte.setComponent(new MyJComboBox(listaDeportes));
			xd.put(errores.DEPORTE, deporte);
		}
		{
			//[width=165,height=20]
			tablemodel = new LugarRealizacionTM();
			tablalugares = new MyJTable(tablemodel);
			tablalugares.setColumnWidths(20,290,100);
			lugar.setComponent(new JScrollPane(tablalugares));
			xd.put(errores.LUGAR, deporte);
		
		}
		{
			String listaModalidades[] = {"Liga","Eliminatoria simple", "Eliminatoria doble"};
			modalidad.setComponent(new MyJComboBox(listaModalidades));
			xd.put(errores.MODALIDAD, modalidad);
		}
		{
			String listaFormasPuntuacion[] = {"Sets", "Puntuación", "Resultado final"};
			formapuntuacion.setComponent(new MyJComboBox(listaFormasPuntuacion));
			xd.put(errores.SISTEMAPUNTUACION, formapuntuacion);
		}
		{
			empatepermitido.setComponent(new JCheckBox());
			
			puntosporpartidoganado.setComponent(new JSpinner(new SpinnerNumberModel(3,1,100,1)));
			       puntosporempate.setComponent(new JSpinner(new SpinnerNumberModel(1,0,100,1)));
			  puntosporpresentarse.setComponent(new JSpinner(new SpinnerNumberModel(0,0,100,1)));
			  cantidadmaximadesets.setComponent(new JSpinner(new SpinnerNumberModel(3,1,100,2)));
			     puntosporabandono.setComponent(new JSpinner(new SpinnerNumberModel(3,0,100,1)));
			
		}
		{
			reglamento.setComponent(new MyJTextArea("(Opcional)Ingrese uno..."));
			reglamento.error().setVisible(false);
			xd.put(errores.REGLAMENTO, reglamento);
		}
		{
			Gui.colocar2(0, 0, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, insetvacio, panelBotones, botoncancelar);
			Gui.colocar2(1, 0, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, insetvacio, panelBotones, new JLabel("    "));
			Gui.colocar2(2, 0, 1, 1, 0, 0, 0, 0, Gui.NONE, Gui.WEST, insetvacio, panelBotones, botonaceptar);
			botonaceptar.setEnabled(false);
			botonaceptar.addActionListener(e->{
				
				dto=new CompetenciaDTO();
				dto.setNombre(nombre.component().getText());
				dto.setDeporte(deporte.component().getSelectedIndex());
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
				
				this.validar(gestor.crearCompetencia(dto));
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
						
			nombre.component().addActionListener(e->{
				botonaceptar.setEnabled(nombre.component().hasChanged() && nombre.component().getText()!=null);	
			});
			
		}
		{
			
			Gui.colocar(0,0,3,1,0,0,0,0,Gui.NONE,Gui.CENTER,this, titulo);

//			Gui.colocar(0,1,1,1,0,0,0,0,Gui.NONE,Gui.WEST,this, tnombre);
//			Gui.colocar(1,1,1,1,0,0,0,0,Gui.HORIZONTAL,Gui.WEST,this, panel[0]);
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
			Gui.colocar(2,7,1,1,1,0,0,0,Gui.HORIZONTAL,Gui.CENTER,this, puntosporabandono.full());
			
			
			Gui.colocar(0,9,1,1,0,0,0,0,Gui.NONE,Gui.NORTHWEST,this, reglamento.label());
			Gui.colocar(1,9,2,1,1,1,0,0,Gui.BOTH,Gui.WEST,this, reglamento.semi2());
			
			Gui.colocar(2,10,1,1,0,0,0,0,Gui.NONE,Gui.CENTER,this, panelBotones);

			
		}
		
	}
	
	private void validar(Mensaje<errores> m) {
		if(m.getMensaje().containsKey(errores.EXITO))
			return;
		for(Map.Entry<errores, String> i : m.getMensaje().entrySet()) {
			xd
			.get(i.getKey())
			.showError(i.getValue());
		}
	}
	

	
	
}
