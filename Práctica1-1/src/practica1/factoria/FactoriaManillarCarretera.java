package practica1.factoria;

public class FactoriaManillarCarretera implements FactoriaManillar{

	@Override
	public ManillarCarretera crearManillar() {
		return new ManillarCarretera();
	}
}
