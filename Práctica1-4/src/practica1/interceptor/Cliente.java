package practica1.interceptor;

public class Cliente {

	private GestorFiltros gestorFiltros;
	
	public Cliente(){
		gestorFiltros = null ;
	}
	
	public void setGestorFiltros(GestorFiltros gestorFiltros) {
		this.gestorFiltros = gestorFiltros;
		
	}

	public void enviarPeticion(double d,double time) {
		gestorFiltros.peticionFiltro(d,time);
	}

}
