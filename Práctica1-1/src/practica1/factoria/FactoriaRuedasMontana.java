package practica1.factoria;

public class FactoriaRuedasMontana implements FactoriaRuedas{

	@Override
	public RuedasMontana crearRuedas() {
		return new RuedasMontana();
	}
}
