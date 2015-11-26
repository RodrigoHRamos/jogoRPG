package jogo.rpg.modelo;

public class EquipamentoDefesa extends Equipamento {

	private int poderDeDefesa;

	public EquipamentoDefesa(int poderDeDefesa) {
		this.setPoderDeDefesa(poderDeDefesa);
	}

	public int getPoderDeDefesa() {
		return poderDeDefesa;
	}

	public void setPoderDeDefesa(int poderDeDefesa) {
		this.poderDeDefesa = poderDeDefesa;
	}

}
