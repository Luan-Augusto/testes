package parte01.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte01.Pessoa;

class PessoaTest {
  @Test
  void testPessoa() {
    // Nome: Fulano - 20 anos - altura: 1.60m - peso: 65kg
    Pessoa p = new Pessoa("Fulano", 20, 1.60, 65.0);
    assertEquals("Fulano", p.getNome());
    assertEquals(20, p.getIdade());
    assertEquals(1.60, p.getAltura());
    assertEquals(65.0, p.getPeso());
  }

  @Test
  void testSetNome() {
    Pessoa p = new Pessoa("Fulano", 20, 1.60, 65.0);
    p.setNome("Cicrano");
    assertEquals("Cicrano", p.getNome());
  }

  @Test
  void testSetIdade() {
    Pessoa p = new Pessoa("Fulano", 20, 1.60, 65.0);
    p.setIdade(25);
    assertEquals(25, p.getIdade());
  }

  @Test
  void testSetAltura() {
    Pessoa p = new Pessoa("Fulano", 20, 1.60, 65.0);
    p.setAltura(1.70);
    assertEquals(1.70, p.getAltura());
  }

  @Test
  void testSetPeso() {
    Pessoa p = new Pessoa("Fulano", 20, 1.60, 65.0);
    p.setPeso(60.0);
    assertEquals(60.0, p.getPeso());
  }

  @Test
  void testGetIMC() {
    // O IMC é calculado dividindo o peso pela altura ao quadrado
    // Ex: Peso = 65 Altura = 1,60 IMC = 64 / (1,60 x 1,60) = 25,0
    Pessoa p = new Pessoa("Fulano", 20, 1.60, 64.0);
    assertEquals(25.0, p.getIMC(), 0.001);
  }

}
