package practica1.factoria;

public class FactoriaCuadroCarretera implements FactoriaCuadro{

	@Override
	public CuadroCarretera crearCuadro() {
		return new CuadroCarretera();
	}
}
