package jogo.rpg.modelo;

import java.util.List;

public interface IPersonagem {

	public abstract void equipar(EquipamentoAtaque ataque, EquipamentoDesefa defesa);
	
	public abstract void reduzPontosDeVida(int dano);
	
	public abstract int getPontosDeVida();
	
	public abstract String exibirInforPersonagem();
	
	public abstract void posicionar(int x, int  y);
	
	public abstract int getPosicaoX();
	
	public abstract int getPosicaoY();

}