package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import gestores.GestorAutenticacion;
import gui.Gui;
import gui.MyIcon;
import gui.PanelFondo;
import gui.PanelPersonalizado;
import paneles.PanelAltaCompetenciaTM;
import paneles.PanelAltaCompetencia;
import paneles.PanelHome;
import paneles.PanelMisCompetencias;


public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panelfondo;
	JButton boton_home;
	JButton boton_volver;
	JPanel actual = null;
	Stack<JPanel> paneles;
	PanelHome home;


	private App() {
		
		this.setTitle("¿Dónde juego?");
		
//		this.setLayout(new GridBagLayout());
//		this.setLayout(new BorderLayout());
//		this.setContentPane(new JPanel(new BorderLayout()));
		paneles = new Stack<JPanel>();
		Gui.setearFuente("Comic Sans MS",this);

		{
			panelfondo = new PanelFondo();
			this.setContentPane(panelfondo);
		}

		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//	this.setPreferredSize(new Dimension(800,600));
		this.setMinimumSize(new Dimension(1400,1024));
		//this.setSize(800,600);
		this.setLocationRelativeTo(null);

		

		//https://stackoverflow.com/questions/2781939/setting-minimum-size-limit-for-a-window-in-java-swing
		this.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e){
				Dimension d=getSize();
				Dimension minD=getMinimumSize();
				if(d.width<minD.width)
					d.width=minD.width;
				if(d.height<minD.height)
					d.height=minD.height;
				setSize(d);
			}
		});

		
		
		MyIcon botonhome = new MyIcon("icon/home.png", 40, 40, false);
		GridBagConstraints c = new GridBagConstraints(1, 1, 1, 1, 1,1, Gui.NORTHWEST, Gui.NONE, new Insets(0,0,0,0), 0, 0);
		this.add(botonhome,c);
		
		GridBagConstraints c2 = new GridBagConstraints(3, 3, 1, 1, 1,1, Gui.NORTHWEST, Gui.NONE, new Insets(0,0,0,0), 0, 0);
		this.add(new MyIcon("icon/empty.png", 40, 40, false),c2);
//		this.getContentPane().add(botonhome,BorderLayout.NORTH);
		botonhome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				volverAHome();
			}
		});
		
		
		
		
		home = new PanelHome(this);
		this.actual = home;
//		PanelAltaCompetencia altaCompetencia = new PanelAltaCompetencia(); 
//		this.cambiarPanel(altaCompetencia);
		//this.cambiarPanel(new PanelMisCompetencias2(this));
		this.nuevoPanel(home);
		
		
		
	}


	public void volverAHome() {
		paneles.clear();
		nuevoPanel(this.home);
	}
	
	public void volverAtras() {
		paneles.pop();
		cambiarPanel(paneles.peek());
	}

	public void nuevoPanel(JPanel p) {
		paneles.push(p);
		cambiarPanel(paneles.peek());
	}
	
	public void cambiarPanel(JPanel p) {
		Dimension d = this.getSize();
		this.remove(actual);
		this.actual = p;
		//this.setContentPane(panel);
		GridBagConstraints c = new GridBagConstraints(2, 2, 1, 1, 0, 0, Gui.NORTH, Gui.BOTH, new Insets(0,0,0,0), 0, 0);
		this.add(this.actual,c);
//		this.getContentPane().add(this.actual,BorderLayout.CENTER);
		this.pack();
		this.revalidate();
		this.repaint();
		this.setSize(d);

	}






	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");			    
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");			    
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

				}
				catch (Exception e) {
					Gui.imprimir(e.getMessage());
				}

				new App().setVisible(true);

				SwingWorker<Void, Void> trabajador = new SwingWorker<Void, Void>(){
					@Override
					protected Void doInBackground() throws Exception {
						GestorAutenticacion ga = new GestorAutenticacion();
//						ga.login("dieguitomaradona@gmail.com", "12345");
						ga.login("ronaldinho@hotmail.com", "6789");
						return null;
					}
				};
				trabajador.execute();

			}
		});

	}
}
