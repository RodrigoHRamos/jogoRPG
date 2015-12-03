package jogo.rpg.modelo;

import java.util.List;

public class Personagem implements IPersonagem {

	private String nome;

	private int força;

	private int percepcao;

	private int destreza;

	private int vitalidade;

	private int agilidade;
	
	private int pontosDeVida;
	
	private int poscicaoX;
	
	private int poscicaoY;
	
	private Comando acao;

	private Equipamento equipamentoAtaque;

	private Equipamento[] equipamentos;

	private Equipamento equipamentoDefesa;

	public Personagem(String nome, int forca, int percepcao, int destreza, int vitalidade, int agilidade) {
		this.nome = nome;
		this.força = forca;
		this.percepcao = percepcao;
		this.destreza = destreza;
		this.vitalidade = vitalidade;
		this.agilidade = agilidade;
		this.vitalidade = vitalidade;
		this.pontosDeVida = this.vitalidade *10;
	}
	
	public Personagem(String nome){
		this.nome = nome;
		this.força = 5;
		this.percepcao = 5;
		this.destreza = 5;
		this.vitalidade = 5;
		this.agilidade = 5;
		this.vitalidade = 5;
		this.pontosDeVida = this.vitalidade *10;
	}

	public void equipar(EquipamentoAtaque ataque, EquipamentoDefesa defesa) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getForça() {
		return força;
	}

	public void setForça(int força) {
		this.força = força;
	}

	public int getPercepcao() {
		return percepcao;
	}

	public void setPercepcao(int percepcao) {
		this.percepcao = percepcao;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getVitalidade() {
		return vitalidade;
	}

	public void setVitalidade(int vitalidade) {
		this.vitalidade = vitalidade;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public Equipamento getEquipamentoAtaque() {
		return equipamentoAtaque;
	}

	public void setEquipamentoAtaque(Equipamento equipamentoAtaque) {
		this.equipamentoAtaque = equipamentoAtaque;
	}

	public Equipamento[] getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(Equipamento[] equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Equipamento getEquipamentoDefesa() {
		return equipamentoDefesa;
	}

	public void setEquipamentoDefesa(Equipamento equipamentoDefesa) {
		this.equipamentoDefesa = equipamentoDefesa;
	}

	@Override
	public void reduzPontosDeVida(int dano) {
		this.pontosDeVida -= dano;
		
	}

	@Override
	public int getPontosDeVida() {
		return this.pontosDeVida;
	}

	@Override
	/**
	 * retorna uma string já formatada com as informacoes do personagem
	 * */
	//TODO acrescentar informações dos equipamentos
	public String exibirInforPersonagem() {
		//Ainda falta colocar todas as outras informações do persongem
		String retorno;
		retorno = "\t" + getNome() + " | Pontos de vida: " + getPontosDeVida()
					+ " - Força: " + getForça() + ", Percepção: " + getPercepcao() + ", Destreza: " + getDestreza() 
					+ ", Vitalidade: " + getVitalidade() + ", Agilidade: " + getAgilidade();
					//+ "Equipamento de Ataque | Dano:" + getEquipamentoAtaque().informaçãoEquipamento()
					//+ "Equipamento de Defesa | Poder:" + getEquipamentoDefesa().informaçãoEquipamento();
		return retorno;
	}

	@Override
	public void posicionar(int x, int y) {
		this.poscicaoX = x;
		this.poscicaoY = y;
		
	}

	@Override
	public int getPosicaoX() {
		return this.poscicaoX;
	}

	@Override
	public int getPosicaoY() {
		return this.poscicaoY;
	}
}
