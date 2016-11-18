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
		if (i > 3 || i < 0 || j > 3 || j < 0) {
			return false;
		}

		if (posicoes[i][j] != 0) {
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

	public boolean fimJogo(int i, int j) {
		return false;
	} 
}
