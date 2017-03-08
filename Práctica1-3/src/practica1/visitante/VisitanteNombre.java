package practica1.visitante;

public class VisitanteNombre extends VisitanteEquipo {
	private String nombre;
	
	VisitanteNombre(){
		nombre = "";
	}
	
	public String nombre(){
		return nombre;
	}

	@Override
	public void visitarDisco(Disco d) {
		nombre += " *"+d.nombre()+"* ";
	}

	@Override
	public void visitarTarjeta(Tarjeta t) {
		nombre += " *"+t.nombre()+"* ";
	}

	@Override
	public void visitarBus(Bus b) {
		nombre += " *"+b.nombre()+"* ";
	}
}

