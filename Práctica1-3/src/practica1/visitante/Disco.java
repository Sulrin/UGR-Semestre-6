package practica1.visitante;

public class Disco extends Equipo {
	
	private double precioNeto;
	private double potencia;
	
	public Disco(String nombre, double precioNeto, double potencia){
		super(nombre);
		this.potencia = potencia;
		this.precioNeto = precioNeto;
	}
	
	@Override
	public void aceptar(VisitanteEquipo ve){
		ve.visitarDisco(this);
	}

	@Override
	public double potencia() {
		return potencia;
	}

	@Override
	public double precioNeto() {
		return precioNeto;
	}

}
