package practica1.interceptor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interfaz extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public Interfaz(){
		PanelBotones panel = new PanelBotones();
		setTitle("Practica-1.4");
		getContentPane().add(panel);
		panel.setPreferredSize(new Dimension(450,150));
		//terminar bien el programas
		this.addWindowListener (new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.pack();
		this.setVisible(true);
	}
	public void ejecutar(double peticion,double time){
		
		System.out.println("Para un numero de vueltas del eje= "+peticion + " después "+ (time-DemoInterceptor.initialTime) +" segundos.");
	}
}
