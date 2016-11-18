package br.com.unirriter.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TabuleiroTest {

	@Test
	public void testarTabuleiroNulo() {
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		assertNotNull(tabuleiro);
		
	}
	
	@Test
     public void testarJogada() {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		assertTrue(tabuleiro.efetuarJogada(1,2));
	}
	
	@Test
    public void testarPosicaoInvalida() {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		assertFalse(tabuleiro.efetuarJogada(4,2));
	}
	
	@Test
    public void testarPosicaoJogada() {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		tabuleiro.efetuarJogada(1,1);
		assertFalse(tabuleiro.efetuarJogada(1,1));
	}
	
	@Test
    public void testarJogador1JaGanhou() {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		tabuleiro.efetuarJogada(0,0);
		tabuleiro.efetuarJogada(1,1);
		
		assertFalse(tabuleiro.fimJogo(1,1));
	}
}




