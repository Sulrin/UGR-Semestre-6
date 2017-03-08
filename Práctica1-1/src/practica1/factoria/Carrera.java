package practica1.factoria;

import java.util.ArrayList;

public interface Carrera {

	public static ArrayList<Bicicleta> crearCarrera(TC tipo,int n){
		if(tipo == TC.MONTANA){
			FactoriaCarreraMontana factoria = new FactoriaCarreraMontana();
			return factoria.crearCarrera(TC.MONTANA,n);
		}
		else{
			FactoriaCarreraCarretera factoria = new FactoriaCarreraCarretera();
			return factoria.crearCarrera(TC.CARRETERA,n);
		}
	}
}
