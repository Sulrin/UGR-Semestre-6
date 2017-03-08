package practica1.factoria;

import java.util.ArrayList;
import java.util.Random;

public class DemoCarrera {
	
	private static int randomInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static Runnable nuevaCarreraStart(ArrayList<Bicicleta> participantes){
		int abandonos;

		// Si el participante tiene una bicicleta de montaña la carrera será de montaña
		String tipoCarrera = participantes.get(0).getTipo().toString();

		System.out.println("Tenemos una carrera de "+tipoCarrera+" con "+participantes.size()+" participantes");
		
		// En la carrera de Carretera se producen 10% de accidentes de entre los participantes
		// en un instante de tiempo X, y en la carrera de Montana se producen el 20%
		if(tipoCarrera == "CARRETERA")
			abandonos = Math.round((participantes.size() * 10)/100);
		else
			abandonos = Math.round((participantes.size() * 20)/100);
		
		participantes.forEach(bicicleta -> bicicleta.start());
		
		Runnable runnable = new Runnable() {
			boolean running = true;
			int segundos = 0, milesimas = 0;
						
			@Override
			public void run(){
				try {	
					System.out.println("Esperando 60s la fin de la carrera de "+tipoCarrera+"...");
		    		while(running) {
		    			Thread.sleep( 5 );
		    		    //Incrementamos 4 milesimas de segundo
		    		    milesimas += 5;		    		   
		    		    
		    		    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
		    		    //y las milesimas de segundo de nuevo a 0
		    		    if( milesimas == 1000 ) {
		    		    	milesimas = 0;
		    		    	segundos++;
		    		    	
		    		    	// despues 40 segundos quitamos algunos de los participantes
		    		    	if (segundos == 40){
		    		    		
		    		    		for (int i = 0; i < abandonos; i++) {
		    		    			participantes.remove(participantes.size() - randomInt(0,participantes.size()));
		    		    		}
		    		    		
		    		    	}else if( segundos == 60 ){ // es la fin de la carrera
		    		    		segundos = 0;
		    		    		running = false;
		    		    		
		    		    		int maxDistance = 0,id = -1;
		    		    		// Paramos las bicicletas
		    		    		for(int i = 0; i<participantes.size(); i++){
		    		    			participantes.get(i).stopCarrera();
		    		    			if(participantes.get(i).distance >= maxDistance){
		    		    				maxDistance = participantes.get(i).distance;
		    		    				id =  participantes.get(i).idParticipante;
		    		    			}
		    		    		}
		    		    		
		    		    		System.out.println("La carrera de "+tipoCarrera+" termina!");
		    		    		System.out.println("El mejor participante de "+tipoCarrera+" es el "+id+" con una distancia de "+maxDistance+" km");
		    		    		
		    		    	}    		    	
		    		    }		    			
		    		}
		    	} catch(Exception e) {
		    		e.getStackTrace();
		    	}
			}
		};
		
		return runnable;
	}
	
	public static void main(String[] args) {
		
	    int numeroDeBicicletas = randomInt(10,60);
		
		// Factoria*.crearCarrera(TC tipo) se encarga de crear los objetos
		ArrayList<Bicicleta> participantesCarretera = Carrera.crearCarrera(TC.CARRETERA, numeroDeBicicletas);
		ArrayList<Bicicleta> participantesMontana = Carrera.crearCarrera(TC.MONTANA,numeroDeBicicletas);
	
		Thread carreraMontana = new Thread(nuevaCarreraStart(participantesCarretera));
		Thread carreraCarretera=  new Thread(nuevaCarreraStart(participantesMontana));
		
		carreraMontana.start();
		carreraCarretera.start();
		
	}

	
	
}
