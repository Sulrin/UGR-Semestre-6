package practica1.interceptor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class PanelBotones extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton botonAcelerar;
	private JToggleButton botonEncender;
	private JLabel etiqMostrarEstado;
	
	public PanelBotones(){
		setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.WHITE));
		
		etiqMostrarEstado = new JLabel("APAGADO");
		etiqMostrarEstado.setVerticalAlignment(SwingConstants.TOP);
		etiqMostrarEstado.setHorizontalAlignment(SwingConstants.CENTER);
		etiqMostrarEstado.setForeground(Color.RED);
		etiqMostrarEstado.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.LIGHT_GRAY));

		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		etiqMostrarEstado = new JLabel("APAGADO");
		etiqMostrarEstado.setVerticalAlignment(SwingConstants.TOP);
		etiqMostrarEstado.setHorizontalAlignment(SwingConstants.CENTER);
		etiqMostrarEstado.setForeground(Color.RED);
		etiqMostrarEstado.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.LIGHT_GRAY));
		
		add(etiqMostrarEstado);
		
		layout.putConstraint(SpringLayout.SOUTH, etiqMostrarEstado, 54, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, etiqMostrarEstado, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, etiqMostrarEstado, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, etiqMostrarEstado, 10, SpringLayout.NORTH, this);
		
		botonEncender = new JToggleButton("Encender");
		
		botonEncender.setForeground(Color.RED);
		
		layout.putConstraint(SpringLayout.SOUTH, botonEncender, -29, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, botonEncender, -233, SpringLayout.EAST, this);
		
		add(botonEncender);
		
		botonEncender.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				BotonEncenderActionPerformed (evt) ; }
		}) ;
		
		botonAcelerar = new JButton("Acelerar");
		
		layout.putConstraint(SpringLayout.NORTH, botonAcelerar, 0, SpringLayout.NORTH, botonEncender);		
		layout.putConstraint(SpringLayout.WEST, botonAcelerar, 22, SpringLayout.EAST, botonEncender);
		
		botonAcelerar.setEnabled(false);
		
		add(botonAcelerar);
		
		botonAcelerar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				BotonAcelerarActionPerformed (evt) ; }
		}) ;
	
	}
	
	//Recogedor de eventos del boton Encender
	synchronized private void BotonEncenderActionPerformed(ActionEvent evt){
		if (botonEncender.isSelected()){
			botonEncender.setForeground(Color.BLUE);
			botonEncender.setText("Apagar");
			etiqMostrarEstado.setText("ENCENDIDO");
			botonAcelerar.setEnabled(true);
			DemoInterceptor.initialTime = System.currentTimeMillis()/1000.0;
			DemoInterceptor.cliente.enviarPeticion(DemoInterceptor.rpm,DemoInterceptor.initialTime + 1);
			DemoInterceptor.initialTime = System.currentTimeMillis()/1000.0 + 1;
		}
		else {
			DemoInterceptor.rpm = 100;
			botonEncender.setForeground(Color.RED);
			botonEncender.setText("Encender");
			etiqMostrarEstado.setText("APAGADO");
			botonAcelerar.setEnabled(false);
		}
	}
	//Recogedor de eventos del boton Acelerar
	synchronized private void BotonAcelerarActionPerformed(ActionEvent evt){
		if(botonEncender.isSelected()) {
			etiqMostrarEstado.setText("ACELERANDO");
			DemoInterceptor.rpm += 10;
			DemoInterceptor.cliente.enviarPeticion(DemoInterceptor.rpm,System.currentTimeMillis()/1000.0);
		}
	}
}