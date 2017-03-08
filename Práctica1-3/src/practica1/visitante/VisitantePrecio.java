package practica1.visitante;

public class VisitantePrecio extends VisitanteEquipo {
	
	private double precioFinal;
	
	public VisitantePrecio(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente ;
	}

	private double aplicacionDelDiscuento(double precio){
		if(TipoCliente.CLIENTEVIP == this.tipoCliente)
			precio = precio-precio*0.10;
		else if(TipoCliente.CLIENTEMAYORISTA == this.tipoCliente)
			precio = precio-precio*0.15;
		
		return precio;
	}
	
	@Override
	public void visitarDisco(Disco d) {
		precioFinal += aplicacionDelDiscuento(d.precioNeto());
	}

	@Override
	public void visitarTarjeta(Tarjeta t) {
		precioFinal += aplicacionDelDiscuento(t.precioNeto());
	}

	@Override
	public void visitarBus(Bus b) {
		precioFinal += aplicacionDelDiscuento(b.precioNeto());
	}
	
	public double precioFinal(){
		return precioFinal;
	}
}
