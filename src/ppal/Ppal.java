package ppal;
import pokemon.*;
import java.util.Scanner;

public class Ppal {

	public static void main(String[] args) {
		Pokemon [] arrayPokemon= {new Fuego("Charizard", 120,15), new Agua("Squirtle", 99,15),
				new Fuego("Charmander",100,10), new Agua("Oshawott",80,10)};
		//generar emparejamientos
		//Combaten todos con todos
		for(int i = 0; i < arrayPokemon.length; i++) {
			for(int j = i+1; j<arrayPokemon.length; j++) {
				combate(arrayPokemon[i], arrayPokemon[j]);
			}
		}
		System.out.println("\t\tFIN DEL CAMPEONATO");
		
	}
	private static void combate(Pokemon pokemon1, Pokemon pokemon2) {
		Scanner sc = new Scanner(System.in);
		
		int auxRand = (int)(Math.random()*2); //random entre 0 y 1
		
		System.out.println("Empieza el combate entre: "+ pokemon1.getNombre() 
							+" y " + pokemon2.getNombre());
		
		while(pokemon1.getVida() > 0 && pokemon2.getVida() > 0) {
			if (auxRand==0) {	//empieza pochemon1
				ataque(pokemon1, pokemon2);				
				if(pokemon2.getVida()>0) //comprobamos si p2 sigue vivo				
					ataque(pokemon2, pokemon1);				
			}			
			else { //empieza pochemon2
				ataque(pokemon2, pokemon1);				
				if(pokemon1.getVida()>0)//comprobamos si p1 sigue vivo	
					ataque(pokemon1, pokemon2);
			}
		}	

		
		System.out.print("FIN DEL COMBATE "+ pokemon1.getNombre() 
		+" VS " + pokemon2.getNombre() + "\tGANADOR: ");

		if(pokemon1.getVida()>0) {
			System.out.println(pokemon1.getNombre());
			pokemon1.setPuntosCampeonato(pokemon1.getPuntosCampeonato()+1);
		}
		else {
			System.out.println(pokemon2.getNombre());
			pokemon2.setPuntosCampeonato(pokemon2.getPuntosCampeonato()+1);
		}		
		
		//restauramos vida y magia para el próximo combate
		pokemon1.setVida(pokemon1.getVidaInicial());
		pokemon1.setpM(pokemon1.getpMInicial());
		pokemon2.setVida(pokemon2.getVidaInicial());
		pokemon2.setpM(pokemon2.getpMInicial());
		
		System.out.println("Pulsa enter para continuar con la siguiente ronda...");
		sc.nextLine();
		//sc.close();
	}

	private static void ataque(Pokemon pokemon1, Pokemon pokemon2) {
		int auxRand = (int)(Math.random()*3); //random entre 0 y 2
		if(auxRand<2)
			pokemon1.ataqueBasico(pokemon2);
		else
			pokemon1.ataqueEspecial(pokemon2);
	}

}
