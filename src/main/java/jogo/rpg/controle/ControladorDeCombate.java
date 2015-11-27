package jogo.rpg.controle;

import jogo.rpg.modelo.ComandoFactory;
import jogo.rpg.modelo.Equipamento;
import jogo.rpg.modelo.EquipamentoAtaque;
import jogo.rpg.modelo.EquipamentoDefesa;
import jogo.rpg.modelo.ComandoAtacar;
import jogo.rpg.modelo.ComandoDefender;
import jogo.rpg.modelo.ComandoEsquivar;
import jogo.rpg.modelo.PersonagemFactory;
import jogo.rpg.modelo.IPersonagem;
import jogo.rpg.modelo.Partida;
import jogo.rpg.modelo.Personagem;

import java.util.Random;

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
		criarOponente();
		criarArena();	
		
		//-------CRIA EQUIPAMENTOS E EQUIPA -----//
		
		// Só pode criar equipamento para o personagemPrincipal uma vez.
		if(Partida.getCombate()==1){
			criarEquipamentos(personagemPrincipal);
			criarEquipamentos(oponente);
		}
		else{
			criarEquipamentos(oponente);
		}
		
		//-------FIM CRIA EQUIPAMENTOS E EQUIPA -----//
		
		
		//-------POSICIONAMENTO NA ARENA -----//
		
			//TODO o posicionamento dos personagens está hardcoded pq ainda falta fazer a lógica disso.
			//Como o foco do projeto é a modelagem, creio que pode ficar assim mesmo.
		
		personagemPrincipal.posicionar(1, 4);
		oponente.posicionar(3, 3);
		posicionarNaArena(personagemPrincipal, true);
		posicionarNaArena(oponente, false);
		
		//-------FIM DO POSICIONAMENTO NA ARENA -----//
		
		//-------EXIBIÇÃO DE INFORMAÇÕES DO ESTADO ATUAL DA PARTIDA -----//
		System.out.println("\n\n\n\n");
		System.out.println("Inicio do combate nº:" + Partida.getCombate());
		System.out.println("Informações dos personagens:");
		System.out.println(personagemPrincipal.exibirInforPersonagem());
		System.out.println(oponente.exibirInforPersonagem());
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
		//TODO Falta elaborar a lógica para a criação dos atributos do oponente, por equanto vai um valor padrão
		oponente = new PersonagemFactory().criarNovoPersonagem("Oponente");
		//TODO falta elaborar a lógica aqui tb
		oponente.posicionar(3, 3);
	}

	public void criarArena() {
		this.arena = new Arena();
	}
	
	/**
	 * Cria um equipamento de defesa e um ataque de forma aleatória para o personagem recebido como parametro.
	 * Deve ser chamado apenas uma vez para o Personagem principal e sempre que for criar um novo oponente.
	 * Existe 50% de chance da arma ser de corpo a corpo ou de distância
	 * o Poder de Ataque ou de Defesa é: random de 0 a 9 + 2x a quantidade de combates
	 * */	
	public void criarEquipamentos(IPersonagem personagem){
		//Cria os equipamentos usando "sorte"
		int randomico;
		boolean bool;
		randomico = numeroAleatorio(10);
		if(randomico%2==0)
			bool=true;
		else
			bool=false;
		EquipamentoAtaque ataque = new EquipamentoAtaque(randomico+(Partida.getCombate()*2),bool);
		randomico = numeroAleatorio(10);
		EquipamentoDefesa defesa = new EquipamentoDefesa(randomico+(Partida.getCombate()*2));
		//Equipa os equipamentos no personagem
		personagem.equipar(ataque, defesa);			
	}
	/**
	 * Retorna um numero aleatorio de acordo com o valor recebido como param, exe: param = 2 retorna 0 ou 1; param 100 retorna de 0 a 99.
	 * Útil para gerar atributos randomicos para os Personagens e verificar verdadeiros ou falso aleatóriamente.
	 * Utilizar qdo o sistema depender de "Sorte".
	 * */
	public int numeroAleatorio(int num){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(num);
		return randomInt;
	}
	
	

}