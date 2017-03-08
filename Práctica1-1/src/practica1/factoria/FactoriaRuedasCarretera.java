package practica1.factoria;

public class FactoriaRuedasCarretera implements FactoriaRuedas{

	@Override
	public RuedasCarretera crearRuedas() {
		return new RuedasCarretera();
	}
}
