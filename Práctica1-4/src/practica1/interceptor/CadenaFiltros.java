package practica1.interceptor;

import java.util.ArrayList;

public class CadenaFiltros {
	private ArrayList<Filtro> filtros; // declarar: filtros es un ArrayList generico de elementos Filtro
	private Interfaz objetivo;
	
	public CadenaFiltros(){
		filtros = new ArrayList<Filtro>();
	}
	
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}	
	public void ejecutar(double peticion,double seconds){
		for(Filtro filtro : filtros){
			filtro.ejecutar(peticion,seconds);
		}
		objetivo.ejecutar(peticion,seconds);
	}
	public void setObjetivo(Interfaz objetivo){
		this.objetivo = objetivo;
	}
}
