package practica1.factoria;

public class FactoriaManillarMontana implements FactoriaManillar{

	@Override
	public ManillarMontana crearManillar() {
		return new ManillarMontana();
	}
}
