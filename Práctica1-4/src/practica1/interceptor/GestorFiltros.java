package practica1.interceptor;

public class GestorFiltros {
	
	private CadenaFiltros cadenaFiltros;
	
	public GestorFiltros(Interfaz objetivo){
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setObjetivo(objetivo);
	}
	
	public void setFiltro(Filtro filtro){
		cadenaFiltros.addFiltro(filtro);
	}
	
	public void peticionFiltro(double peticion,double seconds){
		cadenaFiltros.ejecutar(peticion,seconds);
	}

}
