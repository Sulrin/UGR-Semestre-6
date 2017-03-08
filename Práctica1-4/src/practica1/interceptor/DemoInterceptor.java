package practica1.interceptor;

public class DemoInterceptor {
	
	static public int rpm;
	static public double initialTime;
	static public double velocidad;
	static public double gasolina;
	static public Cliente cliente;
	
	public static void main(String[] args) {
		rpm = 100;
		initialTime =System.currentTimeMillis()/1000.0;
		gasolina = 60.0;
		cliente = new Cliente();
		GestorFiltros gestorFiltros = new GestorFiltros(new Interfaz());
		gestorFiltros.setFiltro(new CalcularVelocidad());
		gestorFiltros.setFiltro(new CalcularDistancia());
		gestorFiltros.setFiltro(new CalcularGasolina());

		cliente.setGestorFiltros(gestorFiltros);
	}
}
