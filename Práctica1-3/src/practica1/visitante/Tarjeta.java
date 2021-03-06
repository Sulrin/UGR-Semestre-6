package practica1.visitante;

public class Tarjeta extends Equipo {
	
	private double precioNeto;
	private double potencia;

	public Tarjeta(String nombre, double precioNeto, double potencia){
		super(nombre);
		this.potencia = potencia;
		this.precioNeto = precioNeto;
	}

	@Override
	public double potencia() {
		return potencia;
	}

	@Override
	public double precioNeto() {
		return precioNeto;
	}

	@Override
	public void aceptar(VisitanteEquipo ve) {
		ve.visitarTarjeta(this);
	}

}
