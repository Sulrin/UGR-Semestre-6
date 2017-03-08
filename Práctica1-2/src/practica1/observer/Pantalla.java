package practica1.observer;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pantalla extends JFrame implements Observador{
	
	private static final long serialVersionUID = 1L;
	
	BotonCambioPanel botonCambioPanel;
	GraficaTemperaturaPanel graficaTemperaturaPanel;
	int temperaturaActual;

	public Pantalla(){
		temperaturaActual = 0;
		iniciarComponents();
	}

	private void iniciarComponents(){
		this.setTitle("Temperaturas");
		JPanel panel = new JPanel();
		
		botonCambioPanel = new BotonCambioPanel(temperaturaActual);
		graficaTemperaturaPanel = new GraficaTemperaturaPanel("Monitor de los resueltos");
		
		panel.add(botonCambioPanel);
		panel.add(graficaTemperaturaPanel);
		this.getContentPane().add(panel);
		this.setPreferredSize(new Dimension(800, 600));
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void refrescarPantalla(){
		this.repaint();
	}

	@Override
	public void manejarEvento(int temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
		refrescarPantalla();
	}

}
