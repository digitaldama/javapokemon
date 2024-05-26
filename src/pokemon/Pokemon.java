package pokemon;

//Esto es un COMENTARIO PARA LA PRACTICA DE ENTORNOS
//añado un comentario más
public abstract class Pokemon {
	protected String nombre;
	private String tipo;
	protected int vidaInicial; // Puntos de vida máximos
	protected int pMInicial; // Puntos de magia máximos
	protected int vida; // Puntos de vida actuales
	protected int pM; // Puntos de magia actuales
	protected int puntosCampeonato;
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	public String getTipo() {
		return tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaInicial() {
		return vidaInicial;
	}
	public void setVidaInicial(int vidaInicial) {
		if(vidaInicial > 100)
			this.vidaInicial = 100;
		else{ 
			if(vidaInicial < 0)
				this.vidaInicial = 0;
			else
				this.vidaInicial = vidaInicial;
		}
	}

	public int getpMInicial() {
		return pMInicial;
	}	
	public void setpMInicial(int pM_Inicial) {
		if(pMInicial > 20)
			this.pMInicial = 20;
		else{ 
			if(pMInicial < 0)
				this.pMInicial = 0;
			else
				this.pMInicial = pM_Inicial;
		}
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		if(vida>= this.getVidaInicial())
			this.vida= this.getVidaInicial();
		else{ 
			if(vida< 0)
				this.vida= 0;
			else
				this.vida= vida;
		}
	}
	
	public int getpM() {
		return pM;
	}
	public void setpM(int pM) {
		if(pM>= this.getpMInicial())
			this.pM= this.getpMInicial();
		else{ 
			if(pM< 0)
				this.pM= 0;
			else
				this.pM= pM;
		}
	}
	
	public int getPuntosCampeonato() {
		return puntosCampeonato;
	}
	public void setPuntosCampeonato(int puntos_campeonato) {
		if(puntos_campeonato < 0)
			this.puntosCampeonato = 0;
		else
			this.puntosCampeonato = puntos_campeonato;
	}
	
	public void ataqueBasico(Pokemon pokemonRival) {
		System.out.println("\t"+this.getNombre() + " ataca con ataque básico a "+ pokemonRival.getNombre());
		//otroPoche.vida-=10;
		pokemonRival.setVida(pokemonRival.getVida()-10);
		System.out.println("\t"+pokemonRival.getNombre() + " vida: "+ pokemonRival.getVida());
	}
	
	public abstract void ataqueEspecial(Pokemon pokemonRival);
	
	@Override
	public String toString() {
		return this.getNombre() + 
				":\n\tVida máxima: " + this.getVidaInicial() + 
				"\n\tVida actual: " + this.getVida() +
				"\n\tPuntos de magia máximos: " + this.getpMInicial() +
				"\n\tPuntos de magia actuales: " + this.getpM();
	}
	
}
