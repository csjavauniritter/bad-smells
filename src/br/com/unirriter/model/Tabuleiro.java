package br.com.unirriter.model;

public class Tabuleiro {

	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador jogadorAtivo;

	private int[][] posicoes = new int[3][3];

	public Tabuleiro(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogadorAtivo = jogador1;
	}

	public boolean efetuarJogada(int i, int j) {
		if (verificarJogadaInvalida(i, j)) {
			return false;
		}

		if (verificarJogadaRepetida(i, j)) {
			return false;
		}

		int xOuBolinha = 0;
		if (jogadorAtivo.equals(jogador1)) {
			jogadorAtivo = jogador2;
			xOuBolinha = 1;
		} else {
			jogadorAtivo = jogador1;
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

	public boolean fimJogo(int i, int j) {
		return false;
	} 
}
