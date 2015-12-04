package jogo.rpg.modelo;

public abstract class ComandoFactory {

	public static Comando getComando(ComandoEnum comando) {
		switch (comando) {
		case ComandoEnum.ATACAR:
			return new ComandoAtacar();
			break;
		case ComandoEnum.MOVER:
			return new ComandoMover();
			break;
		default:
			throw new IllegalArgumentException("Comando inválido!");
		}
	}

}
