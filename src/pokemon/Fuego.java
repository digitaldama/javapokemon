package pokemon;

public class Fuego extends Pokemon{
	
	public Fuego(String nombre, int vida, int pm) {
		this.setTipo("Fuego");
		this.setNombre(nombre);
		this.setVidaInicial(vida);
		this.setVida(vida);
		this.setpMInicial(pm);
		this.setpM(pm);
		this.setPuntosCampeonato(0);
	}
	@Override
	public void ataqueEspecial(Pokemon pokemonRival) {
		System.out.println("\t"+this.getNombre() + " ataca con ataque Llamarada a "+ pokemonRival.getNombre());		
		if(this.getpM()>=5) {
			ataqueLlamarada(pokemonRival);			
			this.setpM(this.getpM()-5);
		}
		else 
			System.out.println("\t"+this.getNombre()+" falla el ataque, parece cansado");		
	}
	private void ataqueLlamarada(Pokemon pokemonRival) {
		switch(pokemonRival.getTipo()) {
		case "Fuego":
			pokemonRival.setVida(pokemonRival.getVida()-20);
			break;
		case "Planta":
			pokemonRival.setVida(pokemonRival.getVida()-30);
			break;
		case "Agua": 
			pokemonRival.setVida(pokemonRival.getVida()-10);
			break;
		default:
			System.out.println("¡Pokemon de tipo desconocido!");
		}
		System.out.println("\t"+pokemonRival.getNombre() + " vida: "+ pokemonRival.getVida());
	}
	@Override
	public String toString() {
		return super.toString() + ":\n\tTipo: "+getTipo();
	}
	
}
