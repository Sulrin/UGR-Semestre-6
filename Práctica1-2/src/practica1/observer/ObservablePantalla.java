package practica1.observer;

public class ObservablePantalla extends Observable{
	
	public ObservablePantalla(Pantalla pantalla){
		incluirObservador(pantalla);
		incluirObservador(pantalla.graficaTemperaturaPanel);
		incluirObservador(pantalla.botonCambioPanel);
	}

}
