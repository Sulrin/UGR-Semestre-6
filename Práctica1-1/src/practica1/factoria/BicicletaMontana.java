package practica1.factoria;

public class BicicletaMontana extends Bicicleta {

	BicicletaMontana(TC tipo, Manillar m, Cuadro c, Ruedas r,int id) {
		super(tipo, m, c, r,id);
	}

	@Override
	TC getTipo() {
		return tipo;
	}

	@Override
	void setTipo(TC tipo) {
		this.tipo = tipo;
		if(tipo == TC.MONTANA){
			manillar = new ManillarMontana();
			cuadro = new CuadroMontana();
			ruedas = new RuedasMontana();
		}else{
			manillar = new ManillarCarretera();
			cuadro = new CuadroCarretera();
			ruedas = new RuedasCarretera();
		}
	}
	

}
