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

	@Override
	public String informaçãoEquipamento() {
		String retorno;
		retorno = "Equipamento com poder de defesa de: "+getPoderDeDefesa();
		return retorno;
	}

}
