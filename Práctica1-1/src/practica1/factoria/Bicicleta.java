package practica1.factoria;

public abstract class Bicicleta extends Thread {
	
	protected TC tipo;
	protected Manillar manillar;
	protected Cuadro cuadro;
	protected Ruedas ruedas;
	protected int idParticipante;
	
	protected int distance;
	protected boolean corriendo;
	
	
	Bicicleta(TC tipo, Manillar m, Cuadro c, Ruedas r,int id){
		this.tipo = tipo;
		manillar= m;
		cuadro = c;
		ruedas = r;
		idParticipante = id;
		corriendo = true;
	}

	abstract TC getTipo();
	
	abstract void setTipo(TC tipo);

	@Override
	public String toString() {
		 
		return "bicicleta - " + tipo.toString();
	}
	
	public void stopCarrera(){
		corriendo = false;
	}
	
	@Override
	public void run() {
		try {
			while(corriendo){
				// el factorio aleatorio
				sleep((long) ((Math.random()*1)*500));
				distance++;
			}
		} catch(Exception e) {
    		e.getStackTrace();
		}
	}
	
}
