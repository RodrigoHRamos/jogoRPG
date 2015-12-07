package jogo.rpg;

import jogo.rpg.controle.ControladorDaPartida;
import jogo.rpg.controle.ControladorDeCombate;
import jogo.rpg.modelo.Partida;

import java.io.Externalizable;
import java.util.Scanner;

public class Jogo {

	private static final Scanner sc = new Scanner(System.in);

	private int opcaoSelecionada;//Para trabalhar com os menus do jogo
	//Pq os contraladores não vieram junto com a exportacao do Astah? será pq a associação deles está não- navegavel? 
	private ControladorDaPartida controladorDaPartida;
	private ControladorDeCombate controladorDeCombate;
	
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();//fazer isso ou deixar os métodos todos estáticos?
		jogo.iniciarJogo();
	}

	private void iniciarJogo() {
		exibirMenuDoJogo();
		lerEntrada();
		while (opcaoSelecionada != 1 && opcaoSelecionada != 2) {
	         exibirMensagemDeOpcaoInvalida();
	         exibirMenuDoJogo();
	         lerEntrada();
	      }
		
		executarAcaoDoMenuDoJogo(opcaoSelecionada);
	}
	
	private void lerEntrada() {
		opcaoSelecionada = Integer.parseInt(sc.next());
	}


	private void exibirMenuDoJogo() {
		System.out.println("Iniciando o Jogo RPG de Combate.........\n");
		System.out.println("Selecione uma opção:");
		System.out.println("1: Jogar");
	    System.out.println("2: Sair");
	    System.out.print("> ");
	}

	private void executarAcaoDoMenuDoJogo(int opcao) {
		switch (opcao) {
		case 1: // Jogar
			iniciarPartida();
			break;
		case 2: // Sair
			Jogo.finalizarJogo();
		}
	}

	private void iniciarPartida() {
		controladorDaPartida = new ControladorDaPartida(new Partida());//Essa parte não ficou muito clara

		controladorDaPartida.exibirMenuDaPartida();
		lerEntrada();

		while (opcaoSelecionada != 1 && opcaoSelecionada != 2) {
			exibirMensagemDeOpcaoInvalida();
			controladorDaPartida.exibirMenuDaPartida();
			lerEntrada();
		}
		//Lista os personagens ou sai do jogo
		controladorDaPartida.executarAcaoDoMenuDaPartida(opcaoSelecionada);

		selecionarPersonagem();

	}

	private void selecionarPersonagem() {
		//Quando chega aqui, o menu já foi exibido pelo controlador
		lerEntrada();

		while (opcaoSelecionada != 1 && opcaoSelecionada != 2 && opcaoSelecionada != 3) {
			exibirMensagemDeOpcaoInvalida();
			controladorDaPartida.listarPersonagens();
			lerEntrada();
		}

		controladorDaPartida.selecionarPersonagem(opcaoSelecionada);
		
		/*
		 * Tudo que diz respeito ao controlador de partida já foi feito, agora é hora de inicar o combate
		 * */
		iniciarCombate();
	}

	private void iniciarCombate() {
		controladorDeCombate = new ControladorDeCombate();
		controladorDeCombate.inicarCombate();
		
		//Interação com usuário por meio de menus
		while(controladorDeCombate.getSituacaoDoCombate() ==0){//Eqto o personagem principal não vencer (=1) ou perder (=-1)
			controladorDeCombate.exibirAcoesCombate();
			lerEntrada();
			while (opcaoSelecionada != 1 && opcaoSelecionada != 2 && opcaoSelecionada != 3 && opcaoSelecionada != 4 && opcaoSelecionada != 5) {
				exibirMensagemDeOpcaoInvalida();
				controladorDeCombate.exibirAcoesCombate();
				lerEntrada();
			}
			controladorDeCombate.executarAcaoDeCombate(opcaoSelecionada);
			//A IA só executa se o personagem atacar ou mover
			if(opcaoSelecionada == 1 || opcaoSelecionada == 2){
				//Ações da maquina e depois cai no loop novamente
				//TODO desenvolver a IA do oponente
				//Por eqto a IA só ataca... :(
				controladorDeCombate.executarAcaoDeCombate(1);
			}
			
		}
	}
	
	private void exibirMensagemDeOpcaoInvalida() {
		System.err.println(">>> OPÇÃO INVÁLIDA! <<<");
	}

	public static void finalizarJogo() {
		System.out.println(">>> JOGO ENCERRADO <<<");
		System.exit(0);
	}

}
