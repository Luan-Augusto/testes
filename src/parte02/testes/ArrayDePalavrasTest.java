package parte02.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte02.ArrayDePalavras;

class ArrayDePalavrasTest {

  @Test
  void testSetPalavra() {
    ArrayDePalavras a = new ArrayDePalavras(3);
    a.setPalavra(0, "banana");
    a.setPalavra(1, "pitomba");
    a.setPalavra(2, "jabuticaba");
    
    assertEquals("banana", a.getPalavra(0));
    assertEquals("pitomba", a.getPalavra(1));
    assertEquals("jabuticaba", a.getPalavra(2));
  }


  @Test
  void testGetTamanho() {
    ArrayDePalavras a = new ArrayDePalavras(4);
    
    a.setPalavra(0, "televisão");
    a.setPalavra(1, "computador");
    a.setPalavra(2, "ar-condicionado");
    a.setPalavra(3, "mesa");
    
    assertEquals(4, a.getTamanho());
  }

}
