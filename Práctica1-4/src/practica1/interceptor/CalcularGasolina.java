package practica1.interceptor;


public class CalcularGasolina extends Calcular {

	@Override
	public double ejecutar(Object peticion, Object time) {
		/* suponemos que la gasolina utilizada solamente depende 
		** del tiempo desde cual el motor esta encendido y baja linealmente con un valor delta. */
	    double delta = 0.0005;
		DemoInterceptor.gasolina = DemoInterceptor.gasolina-((double)time-DemoInterceptor.initialTime)*delta;
		if(DemoInterceptor.gasolina > 0){
			System.out.println("La gasolina que queda es de "+String.format("%.2f", DemoInterceptor.gasolina)+" litro");
		}else{
			DemoInterceptor.gasolina = 60;
			System.out.println("No quedaba gasolina y entonces nos hemos parrado para llenar otro 60 litros");
			
		}
		return (double)peticion;
	}

}
