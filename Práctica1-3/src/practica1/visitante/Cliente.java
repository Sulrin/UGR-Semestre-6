package practica1.visitante;
import java.util.ArrayList;
import java.util.Random;

public class Cliente implements Runnable{
	
	private ArrayList<Equipo> config;
	
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo equipo3;
	
	private boolean descuentoGente;
	private TipoCliente tipoCliente;
	
	public Cliente(boolean descuento,TipoCliente tipoCliente){
		
		descuentoGente = descuento;
		Random rand = new Random();
		
		config = new ArrayList<>();
		this.tipoCliente = tipoCliente;
		
		equipo1 = new Tarjeta("Tarjeta Nvidia", rand.nextInt(100)+300, 100.0);
		equipo2 = new Bus("USB", rand.nextInt(5)+5, 10.0);
		equipo3 = new Disco("Samsung Disco", rand.nextInt(20)+100,40.0);
		
		config.add(equipo1);
		config.add(equipo2);
		config.add(equipo3);
		
	}

	@Override
	public void run() {
		  
		double precioFinal = 0;

		VisitanteNombre visitanteNombre = new VisitanteNombre();
		for(int i = 0; i< config.size(); i++)
			config.get(i).aceptar(visitanteNombre);
		
		VisitantePrecio visitantePrecio = new VisitantePrecio(tipoCliente);
		for(int i = 0; i< config.size(); i++)
			config.get(i).aceptar(visitantePrecio);
			
		precioFinal = visitantePrecio.precioFinal();
		
		int descuento = 0;
		
		if(tipoCliente == TipoCliente.CLIENTEREGULAR){
			descuento = 0;
		}else if(tipoCliente == TipoCliente.CLIENTEVIP){
			descuento = 10;
		}else{
			descuento = 15;
		}
		  
		
		if(descuentoGente){
			precioFinal -= precioFinal*0.05;
			descuento += 5;
		}
		System.out.println("********************************************************\n"
				+ 		   "	Nombre Configuracion :" +visitanteNombre.nombre()+ "\n"
				+ 		   "	Precio :" +precioFinal+ "\n"
				+		   "	TipoCliente : "+ tipoCliente.toString()
				+ 		   "	Descuento :" +descuento+ "% \n");
	}

}
