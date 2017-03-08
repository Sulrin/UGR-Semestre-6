package practica1.factoria;

import java.util.ArrayList;

public class FactoriaCarreraCarretera implements Carrera{

	private FactoriaCuadroCarretera factoriaCuadro;
	private FactoriaManillarCarretera factoriaManillar;
	private FactoriaRuedasCarretera factoriaRuedas;
	
	public FactoriaCarreraCarretera(){
		factoriaCuadro = new FactoriaCuadroCarretera();
		factoriaManillar = new FactoriaManillarCarretera();
		factoriaRuedas = new FactoriaRuedasCarretera();
	}
	
	protected ArrayList<Bicicleta> crearCarrera(TC tipo,int n) {
		ArrayList<Bicicleta> bicicletasCarretera = new ArrayList<Bicicleta>();
		
		for (int i = 0; i < n; i++) {
			Manillar manillar = factoriaManillar.crearManillar();
			Cuadro cuadro = factoriaCuadro.crearCuadro();
			Ruedas ruedas = factoriaRuedas.crearRuedas();
			
			bicicletasCarretera.add(new BicicletaCarrera(tipo,manillar,cuadro,ruedas,i));
		}
		
		return bicicletasCarretera;
	}

}
