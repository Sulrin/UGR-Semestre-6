package practica1.observer;

import java.util.ArrayList;

public abstract class Observable {
	
	private ArrayList<Observador> observadores;
	
	protected Observable(){
		observadores = new ArrayList<Observador>();
	}
	
	public void incluirObservador(Observador o){
		observadores.add(o);
	}
	
	public void notificarObservadores(int temperaturaActual){
		for (Observador o : observadores) {
			o.manejarEvento(temperaturaActual);
		}
	}
	
	

}
