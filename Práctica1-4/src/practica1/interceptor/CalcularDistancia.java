package practica1.interceptor;


public class CalcularDistancia extends Calcular {

	@Override
	public double ejecutar(Object peticion, Object time) {
	     
		double distancia = ((double)time-DemoInterceptor.initialTime)*DemoInterceptor.velocidad;
		System.out.println("La distancia recorida es de "+String.format("%.2f", distancia)+" m");

		return distancia;
	}

}
