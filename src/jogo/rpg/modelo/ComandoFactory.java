package jogo.rpg.modelo;

public abstract class ComandoFactory {

	public static Comando getComando(ComandoEnum comando) {
		switch (comando) {
		case ATACAR:
			return new ComandoAtacar();
		case MOVER:
			return new ComandoMover();
		default:
			throw new IllegalArgumentException("Comando inválido!");
		}
	}

}
