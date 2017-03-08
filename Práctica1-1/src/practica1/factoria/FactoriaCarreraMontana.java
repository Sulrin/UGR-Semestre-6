package practica1.factoria;

import java.util.ArrayList;

public class FactoriaCarreraMontana implements Carrera {

	private FactoriaCuadroMontana factoriaCuadro;
	private FactoriaManillarMontana factoriaManillar;
	private FactoriaRuedasMontana factoriaRuedas;
	
	public FactoriaCarreraMontana(){
		
		factoriaCuadro = new FactoriaCuadroMontana();
		factoriaManillar = new FactoriaManillarMontana();
		factoriaRuedas = new FactoriaRuedasMontana();
	}
	
	protected ArrayList<Bicicleta> crearCarrera(TC tipo,int n) {
		ArrayList<Bicicleta> bicicletasMontana = new ArrayList<Bicicleta>();
		
		for (int i = 0; i < n; i++) {
			Manillar manillar = factoriaManillar.crearManillar();
			Cuadro cuadro = factoriaCuadro.crearCuadro();
			Ruedas ruedas = factoriaRuedas.crearRuedas();
			
			bicicletasMontana.add(new BicicletaCarrera(tipo,manillar,cuadro,ruedas,i));
		}
		return bicicletasMontana;
	}

}
