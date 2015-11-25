package jogo.rpg.controle;

import jogo.rpg.Jogo;
import jogo.rpg.modelo.PersonagemFactory;
import jogo.rpg.modelo.IPersonagem;
import jogo.rpg.modelo.Partida;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ControladorDaPartida {

	private final Partida partida;
	private Map<Integer, IPersonagem> personagens;

	public ControladorDaPartida(Partida partida) {
		this.partida = partida;
	}

	public void exibirMenuDaPartida() {
		System.out.println("1: Selecionar um personagem");
		System.out.println("2: Sair");
		System.out.print("> ");
	}

	public void executarAcaoDoMenuDaPartida(int opcao) {
		switch (opcao) {
		case 1:
			listarPersonagens();
			break;
		case 2:
			Jogo.finalizarJogo();
		}
	}

	public void listarPersonagens() {
		personagens = new LinkedHashMap<>();
		int i = 0;

		for (IPersonagem personagem : obterPersonagens()) {
			personagens.put(i++, personagem);
			System.out.println(i + ": " + personagem.exibirInforPersonagem());
		}

		System.out.print("> ");
	}

	public void selecionarPersonagem(int opcao) {
		IPersonagem personagemSelecionado = personagens.get(--opcao);
		Partida.setPersonagem(personagemSelecionado);
		
	}

	public Partida getPartida() {
		return partida;
	}

	public static List<IPersonagem> obterPersonagens() {
		IPersonagem conrar = new PersonagemFactory().criarNovoPersonagem("Conrar", 10, 3, 7, 7, 3);
		IPersonagem leofcon = new PersonagemFactory().criarNovoPersonagem("Leofcon", 3, 10, 7, 3, 7);
		IPersonagem tonkim = new PersonagemFactory().criarNovoPersonagem("Tonkim", 6, 6, 6, 6, 6);

		return Arrays.asList(conrar, leofcon, tonkim);
	}
}
