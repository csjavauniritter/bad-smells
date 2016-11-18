package br.com.unirriter.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JogadorTest {

	
	@Test
	public void testarJogadorNulo() {
		Jogador jogador = new Jogador("Bob");
		
		assertNotNull(jogador);
	}
}
