package practica1.visitante;

public abstract class VisitanteEquipo{
	
	protected TipoCliente tipoCliente; 

	public abstract void visitarDisco(Disco d);

	public abstract void visitarTarjeta(Tarjeta t);

	public abstract void visitarBus(Bus b);

 }