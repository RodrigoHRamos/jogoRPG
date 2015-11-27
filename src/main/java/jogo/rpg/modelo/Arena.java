package jogo.rpg.modelo;

public class Arena {

	private String arena[][];

	public Arena() {
		this.arena = new String[6][6];
		int i, j;
		for (i = 0; i < this.arena.length; i++) {
			for (j = 0; j < this.arena[i].length; j++) {
				this.arena[i][j] = "-";
			}
		}
	}

	public void exibir() {
		System.out.println("\n Situacao atual da arena: ('-' são espaços livres | O representa Oponete e P o Personagem Principal )\n");
		int i, j;
		for (i = 0; i < this.arena.length; i++) {
			System.out.print("    ");
			for (j = 0; j < this.arena[i].length; j++) {
				System.out.print(this.arena[i][j]);
				System.out.print("    ");
			}
			System.out.println("");
		}
	}

	public void posicionar(IPersonagem personagem, boolean principal) {
		if (principal==true){
			arena[personagem.getPosicaoX()][personagem.getPosicaoX()]="P";
		}
		else{
			arena[personagem.getPosicaoX()][personagem.getPosicaoX()]="O";
		}
	}

}
