package br.com.unirriter.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
     public void testarJogada() throws Exception {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		assertTrue(tabuleiro.efetuarJogada(1,2, jogador1));
	}
	
	@Test
    public void testarPosicaoInvalida() throws Exception {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		assertFalse(tabuleiro.efetuarJogada(4,2, jogador1));
	}
	
	@Test
    public void testarPosicaoJogada() throws Exception {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		tabuleiro.efetuarJogada(1,1, jogador1);
		assertFalse(tabuleiro.efetuarJogada(1,1, jogador2));
	}
	
	@Test
    public void testarJogador1JaGanhou() throws Exception {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		tabuleiro.efetuarJogada(0,0, jogador1);
		tabuleiro.efetuarJogada(1,1, jogador2);
		
		assertFalse(tabuleiro.fimJogo());
	}
	
	@Test
    public void testarTabuleiroAcabou() throws Exception {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		tabuleiro.efetuarJogada(0,0, jogador1);
		tabuleiro.efetuarJogada(1,1, jogador2);
		tabuleiro.efetuarJogada(0,1, jogador1);
		tabuleiro.efetuarJogada(1,0, jogador2);
		tabuleiro.efetuarJogada(0,2, jogador1);
		
		assertTrue(tabuleiro.fimJogo());
	}
	
	@Test
    public void testarTabuleiroVelha() throws Exception {
		
		Jogador jogador1 = new Jogador("Leo");
		Jogador jogador2 = new Jogador("Mario");
		
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);
		tabuleiro.efetuarJogada(0,0, jogador1);
		tabuleiro.efetuarJogada(0,2, jogador2);
		
		tabuleiro.efetuarJogada(2,2, jogador1);
		tabuleiro.efetuarJogada(2,1, jogador2);
		
		tabuleiro.efetuarJogada(0,1, jogador1);
		tabuleiro.efetuarJogada(1,0, jogador2);
		
		tabuleiro.efetuarJogada(2,0, jogador1);
		tabuleiro.efetuarJogada(1,1, jogador2);
		
		tabuleiro.efetuarJogada(1,2, jogador1);
		
		assertNull(tabuleiro.quemGanhou());
	}
}




