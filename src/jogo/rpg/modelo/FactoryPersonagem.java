package jogo.rpg.modelo;

public class FactoryPersonagem {

	public IPersonagem criarNovoPersonagem(String nome) {
		IPersonagem personagem = new Personagem(nome);
		return personagem;
	}
	
	public IPersonagem criarNovoPersonagem(String nome, int forca, int percepcao, int destreza, int vitalidade, int agilidade) {
		IPersonagem personagem = new Personagem(nome, forca, percepcao, destreza, vitalidade, agilidade);
		return personagem;
	}

}
