package br.com.unirriter.model;

public class Tabuleiro {

	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador jogadorAtivo;

	private int[][] posicoes = new int[3][3];

	public Tabuleiro(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}

	public boolean efetuarJogada(int i, int j, Jogador jogadorAtivo) throws Exception {
		if(this.jogadorAtivo == null){
			this.jogadorAtivo = jogadorAtivo;
		}
		else if(this.jogadorAtivo.equals(jogadorAtivo)){
			throw new Exception("Jogador não pode jogar 2 vezes");
		}else{
			this.jogadorAtivo = jogadorAtivo;
		}

		if (verificarJogadaInvalida(i, j)) {
			return false;
		}

		if (verificarJogadaRepetida(i, j)) {
			return false;
		}

		int xOuBolinha = 0;
		if (this.jogadorAtivo.equals(jogador1)) {
			xOuBolinha = 1;
		} else {
			xOuBolinha = 2;
		}

		posicoes[i][j] = xOuBolinha;

		return true;
	}
	
	private boolean verificarJogadaInvalida(int x, int y) {
		return  ((x > 3 || y < 0) || (y > 3 || y < 0));
	}
	
	private boolean verificarJogadaRepetida(int x, int y) {
		return posicoes[x][y] != 0;
	}

	public boolean fimJogo() {
		return this.verificaPosicaoHorizontal() || 
				this.verificaPosicaoVertical() || this.verificarPosicaoDiagonal1() 
				|| this.verificarPosicaoDiagonal2();
	} 
	
	private boolean verificaPosicaoHorizontal() {
		for (int x = 0; x < 3; x++) {
			if (posicoes[x][0] == 1 && posicoes[x][1] == 1 && posicoes[x][2] == 1) {
				return true;
			}
			
			if (posicoes[x][0] == 2 && posicoes[x][1] == 2 && posicoes[x][2] == 2) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificaPosicaoVertical() {
		for (int y = 0; y < 3; y++) {
			if (posicoes[0][y] == 1 && posicoes[1][y] == 1 && posicoes[2][y] == 1) {
				return true;
			}
			
			if (posicoes[0][y] == 2 && posicoes[1][y] == 2 && posicoes[2][y] == 2) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificarPosicaoDiagonal1() {
		if (posicoes[0][0] == 1 && posicoes[1][1] == 1 && posicoes[2][2] == 1) {
			return true;
		}
		if (posicoes[0][0] == 2 && posicoes[1][1] == 2 && posicoes[2][2] == 2) {
			return true;
		}
		return false;
	}
	
	private boolean verificarPosicaoDiagonal2() {
		if (posicoes[0][2] == 1 && posicoes[1][2] == 1 && posicoes[2][0] == 1) {
			return true;
		}
		if (posicoes[0][2] == 2 && posicoes[1][2] == 2 && posicoes[2][0] == 2) {
			return true;
		}
		return false;
	}
}
