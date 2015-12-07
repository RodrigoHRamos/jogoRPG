package jogo.rpg.modelo;

import java.util.Random;

public class ComandoAtacar implements Comando {
	
	public ComandoAtacar() {		
		
	}
	/*retorna um numero de 0 a 100, esse valor é confrontado com a chance de acertar do o ataque*/
	public int percentual(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(101);
		return randomInt;
	}

	/**
	 * @return 
	 * @see jogo.rpg.modelo.Comando#executar()
	 */
	public Boolean executar(IPersonagem atacante, IPersonagem atacado) {
		//TODO verificar se está na distancia certa para atacar
		//Verifica se o atacante acertou o atacado
		if(atacante.getPercentualAtaque() > percentual()){
			//Atacado tenta defender ou esquivar, irá tentar oq tiver maior chance
			if(atacado.getPercentualDefesa()>atacado.getPercentualEsquiva()){//tenta defender
				if(atacante.getPercentualDefesa() > percentual())//Consegue Defender
					return false;
				else
					return true;
			}else{//tenta esquivar
				if(atacante.getPercentualEsquiva() > percentual())//Consegue Esquivar
					return false;
				else
					return true;
			}
		}
		else{
			return false;
		}
	}



}
