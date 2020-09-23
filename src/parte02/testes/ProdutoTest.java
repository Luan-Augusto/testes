package parte02.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte02.Produto;

class ProdutoTest {

  @Test
  void testToString() {
    Produto p = new Produto("Coxinha", 3.5);
    assertEquals("Coxinha - R$ 3.5", p.toString());
  }

}
