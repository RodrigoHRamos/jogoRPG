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
	

	private EquipamentoAtaque equipamentoAtaque;

	private EquipamentoAtaque[] equipamentosAtaque;
	
	private EquipamentoDefesa equipamentoDefesa;
	
	private EquipamentoDefesa[] equipamentosDefesa;

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
	//Dados padrão do oponente
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
		this.equipamentoAtaque = ataque;
		this.equipamentoDefesa = defesa;
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

	public void setEquipamentoAtaque(EquipamentoAtaque equipamentoAtaque) {
		this.equipamentoAtaque = equipamentoAtaque;
	}

	public Equipamento getEquipamentoDefesa() {
		return equipamentoDefesa;
	}

	public void setEquipamentoDefesa(EquipamentoDefesa equipamentoDefesa) {
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
	public String exibirInforPersonagem() {
		//Ainda falta colocar todas as outras informações do persongem
		String retorno;
		retorno = "\t" + getNome() + " | Pontos de vida: " + getPontosDeVida()
					+ " - Força: " + getForça() + ", Percepção: " + getPercepcao() + ", Destreza: " + getDestreza() 
					+ ", Vitalidade: " + getVitalidade() + ", Agilidade: " + getAgilidade();
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
	/**
	 * @return the equipamentosAtaque
	 */
	public EquipamentoAtaque[] getEquipamentosAtaque() {
		return equipamentosAtaque;
	}
	/**
	 * @param equipamentosAtaque the equipamentosAtaque to set
	 */
	public void setEquipamentosAtaque(EquipamentoAtaque[] equipamentosAtaque) {
		this.equipamentosAtaque = equipamentosAtaque;
	}
	/**
	 * @return the equipamentosDefesa
	 */
	public EquipamentoDefesa[] getEquipamentosDefesa() {
		return equipamentosDefesa;
	}
	/**
	 * @param equipamentosDefesa the equipamentosDefesa to set
	 */
	public void setEquipamentosDefesa(EquipamentoDefesa[] equipamentosDefesa) {
		this.equipamentosDefesa = equipamentosDefesa;
	}
	@Override
	public Boolean armaDeDistancia() {
		if(this.equipamentoAtaque.isAtacaDistancia()){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public int getPoderDaArma() {
		return this.equipamentoAtaque.getPoderDeDano();
	}
	@Override
	public int getPoderDeDefesa() {
		return this.equipamentoDefesa.getPoderDeDefesa();
	}
	
	@Override
	public int getPercentualAtaque() {
		//Calcula chance de acertar de acordo com o requisito 2.1.15
		int chanceAcerto = this.getDestreza()*8;
		if (chanceAcerto > 95)
			chanceAcerto = 95;
		return chanceAcerto;
	}
	@Override
	public int getPercentualDefesa() {
		//Calcula chance de defesa de acordo com o requisito 2.1.16
		int chanceDefesa = this.getForça()*4 + this.getAgilidade()*3;
		if (chanceDefesa > 95)
			chanceDefesa = 95;
		return chanceDefesa;
	}
	@Override
	public int getPercentualEsquiva() {
		//Calcula chance de esquiva de acordo com o requisito 2.1.17
		int chanceEsquiva = this.getPercepcao()*4 + this.getAgilidade()*3;
		if (chanceEsquiva > 95)
			chanceEsquiva = 95;
		return chanceEsquiva;
	}
	
}
