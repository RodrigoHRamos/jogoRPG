package jogo.rpg.modelo;

public class EquipamentoAtaque extends Equipamento {

	private boolean atacaDistancia;

	private int poderDeDano;

	public EquipamentoAtaque(int poderDeDano, boolean atacaDistancia) {
		this.atacaDistancia = atacaDistancia;
		this.poderDeDano = poderDeDano;
	}

	public boolean isAtacaDistancia() {
		return atacaDistancia;
	}

	public void setAtacaDistancia(boolean atacaDistancia) {
		this.atacaDistancia = atacaDistancia;
	}

	public int getPoderDeDano() {
		return poderDeDano;
	}

	public void setPoderDeDano(int poderDeDano) {
		this.poderDeDano = poderDeDano;
	}

	@Override
	public String informaçãoEquipamento() {
		String retorno;
		if(isAtacaDistancia())
			retorno="Arma de ataque a distância com dano de: "+getPoderDeDano();
		else
			retorno="Arma de ataque corpo a corpo com dano de: "+getPoderDeDano();
		return retorno;
	}

}
