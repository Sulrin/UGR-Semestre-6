package practica1.factoria;

public class FactoriaCuadroMontana implements FactoriaCuadro{

	@Override
	public CuadroMontana crearCuadro() {
		return new CuadroMontana();
	}
}
