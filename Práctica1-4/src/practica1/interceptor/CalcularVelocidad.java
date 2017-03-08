package practica1.interceptor;

public class CalcularVelocidad extends Calcular{

	private double velocidad;
	private double diametro;
	
	public CalcularVelocidad() {
		//initialize velocidad
		velocidad = 0;

		// diametro de la rueda en cm
		diametro = 60;
	}

	public double ejecutar(Object peticion,Object time) {
		
		// caluculamos la velocidad angular
		double angularVelocidad = (2 * Math.PI * (double) peticion) / 60;
		
		// velocidad en m/s
		velocidad = (angularVelocidad*(diametro/100)); //* (3600.0/1000.0);
		System.out.println("La velocidad del coche es de "+String.format("%.2f", velocidad)+" (m/s) ");
		DemoInterceptor.velocidad = velocidad;
		return velocidad;
	}
}