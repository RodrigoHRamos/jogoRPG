package jogo.rpg.controle;

import jogo.rpg.modelo.ComandoFactory;
import jogo.rpg.modelo.ComandoAtacar;
import jogo.rpg.modelo.ComandoDefender;
import jogo.rpg.modelo.ComandoEsquivar;
import jogo.rpg.modelo.PersonagemFactory;
import jogo.rpg.modelo.IPersonagem;
import jogo.rpg.modelo.Partida;
import jogo.rpg.modelo.Personagem;
import jogo.rpg.modelo.Arena;

public class ControladorDeCombate {

	private IPersonagem personagemPrincipal;
	private IPersonagem oponente;
	private Arena arena;
	private int combate;
	private boolean ehVezdoJogadorPrincipal = true;

	/*
	 * O Controlador do combate precisa saber quem é o personagem pricipal e
	 * quantos combates já ocorreram, Quem tem essa informação é a Classe
	 * Partida (Singleton).
	 */

	public ControladorDeCombate() {
		// Pego o personagem principal pela classe Partida.
		// Como é tipo ponteiro, as mudanças que eu faço no PersonagemPrincipal
		// são replicadas no Partida.Personagem
		personagemPrincipal = Partida.getPersonagem();
		combate = Partida.getCombate();
	}

	public void inicarCombate() {
		System.out.println("Inicio do combate nº:" + Partida.getCombate());
		System.out.println("Informaçoes do personagem principal:");
		System.out.println(personagemPrincipal.exibirInforPersonagem());
		criarOponente();
		criarArena();
		
		//TODO
		// criar equipamentos de ataque e defesa
		// equipar jogador e oponente
		
		//TODO o posicionamento dos personagens está hardcoded pq ainda falta fazer a lógica disso
		personagemPrincipal.posicionar(1, 4);
		oponente.posicionar(3, 3);
		
		posicionarNaArena(personagemPrincipal, true);
		posicionarNaArena(oponente, false);
		arena.exibir();
		exibirAcoesCombate();

	}

	public void exibirAcoesCombate() {
		System.out.println("1: Atacar Oponente");
		System.out.println("2: Mover");
		System.out.println("3: Sair");
		System.out.print("> ");
		System.out.print("\t Ainda falta programar o resto do jogo. ");
		
		/*
		 * Se escolheu atacar, verifica a distancia e o equipamente de ataque
		 * 		se estiver tudo ok, realiza ataque, que vai disparar tentativa de esquiva/defesa, se tudo certo tira causa dano (diminui vitalidade)
		 * Se escolheu mover, pede a direção, se direção permitidade move e atualiza a arena
		 * Em qualquer um desses casos, ao termíno troca o turno e é a vez da maquina, após a maquina, chamar essa função novamente.
		 * repetir tudo isso até a vitalidade de alguém chegar a <=0
		 * Ai vem o menu de pós combate (talvez criar um controller para isso)
		 * Após o menu pós combate inicar o combate novamente, e ai fecha o loop e só sai qdo o jogador escolher 'sair'; 
		 * */
	}

	public void executarAcaoSelecionada(int opcao) {

	}
	public void posicionarNaArena(IPersonagem personagem, boolean principal){
		//TODO lógica para verificar se o local onde será inserido e válido.
		arena.posicionar(personagem,principal);
	}

	public void criarOponente() {
		/*TODO Falta elaborar a lógica para a criação dos atributos do oponente, por equanto vai um valor padrão*/
		oponente = new PersonagemFactory().criarNovoPersonagem("Oponente");
		//TODO falta elaborar a lógica aqui tb
		oponente.posicionar(3, 3);
	}

	public void criarArena() {
		this.arena = new Arena();
	}

}
