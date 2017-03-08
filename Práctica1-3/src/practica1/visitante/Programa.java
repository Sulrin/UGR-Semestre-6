package practica1.visitante;

import java.util.ArrayList;
import java.util.Random;

public class Programa {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		ArrayList<Thread> threads = new ArrayList<>();
		ArrayList<TipoCliente> losClientes = new ArrayList<>();
		int numeroDeClientesRegular = 0,numeroDeClientesVIP = 0,numeroDeClientesMayorista = 0;
		
		for (int i = 0; i < 100; i++) {
			TipoCliente tempTipo = TipoCliente.generar(rand.nextInt(3));
			if(tempTipo == TipoCliente.CLIENTEREGULAR){
				++numeroDeClientesRegular;
			}else if(tempTipo == TipoCliente.CLIENTEVIP){
				++numeroDeClientesVIP;
			}else{
				++numeroDeClientesMayorista;
			}
			losClientes.add(tempTipo);
		}
		
		boolean descuentoRegular = false ,descuentoVIP = false,descuentoMayorista =false;
		
		if(numeroDeClientesMayorista >= 25)
			descuentoMayorista = true;
		if(numeroDeClientesVIP >= 25)
			descuentoVIP = true;
		if(numeroDeClientesRegular >= 25)
			descuentoRegular = true;
		
		for (TipoCliente tipoCliente : losClientes) {
			Cliente cliente;
			
			if(tipoCliente == TipoCliente.CLIENTEREGULAR){
				cliente = new Cliente(descuentoRegular, tipoCliente);
			}else if(tipoCliente == TipoCliente.CLIENTEVIP){
				cliente = new Cliente(descuentoVIP, tipoCliente);
			}else{
				cliente = new Cliente(descuentoMayorista, tipoCliente);
			}
			
			threads.add(new Thread(cliente));
			
		}
		System.out.println("There is a total of "+numeroDeClientesRegular+" cliente regular, \n"
							+numeroDeClientesMayorista+" cliente mayorista y \n"
							+numeroDeClientesVIP+" cliente VIP");
		
		
		
		for (Thread t : threads) {
			t.start();
		}
	}

}
