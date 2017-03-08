package practica1.visitante;




public enum TipoCliente {

	CLIENTEREGULAR(0),CLIENTEVIP(1),CLIENTEMAYORISTA(2);
	
	private int tipo;
	
	TipoCliente(int tipo){
		this.tipo = tipo;
	}
	
	public int getTipo(){
		return tipo;
	}
	
	@Override
	public String toString() {
		String s;
		switch(tipo){
		case 0:
			s = "Cliente Regular"; 
			break;
		case 1:
			s = "Cliente VIP";
			break;
		default:
			s = "Cliente Mayorista";
		}
		return s;
	}
	
	public static TipoCliente generar(int tipoCliente){
		TipoCliente tipo = null;
		switch(tipoCliente){
			case 0:
				tipo = CLIENTEREGULAR; 
				break;
			case 1:
				tipo = CLIENTEVIP;
				break;
			default:
				tipo = CLIENTEMAYORISTA;
		}
		return tipo;
	}
}