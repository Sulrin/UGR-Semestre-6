package practica1.observer;

import java.util.Random;

public class Simulador extends Thread{
	
	private int t1,t2;
	private int temperaturaActual;
	public static ObservablePantalla observablePantalla;
	
	Simulador(int t1,int t2){
		this.t1 = t1;
		this.t2 = t2;
		observablePantalla = new ObservablePantalla(new Pantalla());
	}
	
	@Override
	public void run() {
		Random r= new Random();

		while (true){

			temperaturaActual= r.nextInt(t2-t1) + t1;

			try {
				//actualiza la temperatura cada 60 segundos
				sleep(60*1000);
			}catch(java.lang.InterruptedException e){

		    e.printStackTrace();

			}
			observablePantalla.notificarObservadores(temperaturaActual);

		}
		
	}
	
}
