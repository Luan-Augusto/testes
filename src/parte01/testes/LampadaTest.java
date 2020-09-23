package parte01.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte01.Lampada;

class LampadaTest {

  @Test
  void testLampada() {
    Lampada l = new Lampada("Sala");
    assertEquals("Sala", l.getNome());
    // A lâmpada, quando criada, deve estar desligada
    assertFalse(l.isLigada());
  }

  @Test
  void testAlternar() {
    Lampada l = new Lampada("Cozinha");
    // A lâmpada quando criada, deve estar desligada 
    l.alternar(); // Alterna o estado --> liga
    assertTrue(l.isLigada());
    l.alternar(); // Alterna o estado --> desliga
    assertFalse(l.isLigada());
  }

  @Test
  void testSetNome() {
    Lampada l = new Lampada("Garagem");
    l.setNome("Quarto");
    assertEquals("Quarto", l.getNome());
  }
}
