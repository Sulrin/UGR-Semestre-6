package practica1.factoria;

public enum TC {
	MONTANA(0), CARRETERA(1);
	
	private int tipo;
	
	TC(int tipo){
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		if(tipo == 0)
			return "Montaña";
		else
			return "Carretera";
	}
}
