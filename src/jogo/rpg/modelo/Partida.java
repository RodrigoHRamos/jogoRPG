package jogo.rpg.modelo;

public class Partida {

	private static Partida instanciaUnicaDapartida;

	//private Combate[] combate; // verificar se de fato precisa, creio que só precisa de um contato para saber qual é o combate atual
	
	private static int combate=1;

	private static IPersonagem personagem; // verificar se de fato precisa. R: Precisa, a partida precisa saber qual o personagem principal.

	private void Partida() {
	}

	public static Partida getInstance() {
		if(instanciaUnicaDapartida == null){
			instanciaUnicaDapartida = new Partida();
		}
		return instanciaUnicaDapartida;
	}

	public static IPersonagem getPersonagem() {
		return personagem;
	}

	public static void setPersonagem(IPersonagem personagem) {
		Partida.personagem = personagem;
	}
	
	public static int getCombate(){
		return Partida.combate;
	}
	
	/**
	 * Incrementa em +1 o numero de combates
	 * */ 
	public static void setCombate(){
		Partida.combate++;
	}
	
	

}
