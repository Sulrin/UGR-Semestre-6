package practica1.observer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BotonCambioPanel extends JPanel implements Observador {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int temperaturaActual;
	private JButton botonCambio;
	private JLabel etiqueta;
	private JTextArea texto;
	
	public BotonCambioPanel(int temperaturaActual){
		this.temperaturaActual = temperaturaActual;
		botonCambio = new JButton("Introducir temperatura adicional");
		etiqueta = new JLabel("Temperatura Actual "+ temperaturaActual +"°");
		texto = new JTextArea(1,4);
		botonCambio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String entry = texto.getText();
            	if(isNumber(texto.getText()))
            		setTemperatura(Integer.parseInt(entry));
            }

        });	
		add(etiqueta,BorderLayout.NORTH);
		add(botonCambio,BorderLayout.CENTER);
		add(texto,BorderLayout.SOUTH);
	}

	private void setTemperatura(int nuevaTemperatura) {
		Simulador.observablePantalla.notificarObservadores(nuevaTemperatura);
	}
	
	@Override
	public void manejarEvento(int temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
		refrescarPantalla();
		
	}
	
	private void refrescarPantalla(){
		etiqueta.setText("Temperatura Actual "+ temperaturaActual +"°");
	}
	
	private boolean isNumber(String entry){
		try{  
			@SuppressWarnings("unused")
			int i = Integer.parseInt(entry);  
		}catch(NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}

}
