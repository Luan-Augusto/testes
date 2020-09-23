package parte01.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parte01.Calculadora;

class CalculadoraTest {
  private Calculadora c;

  @BeforeEach
  void setUp() throws Exception {
    c = new Calculadora();
  }

  @Test
  void testSoma() {
    assertEquals(4.0, c.soma(2.0, 2.0));
    assertEquals(8.0, c.soma(3.0, 5.0));
    assertEquals(0.0, c.soma(2.0, -2.0));
  }

  @Test
  void testSubtrai() {
    assertEquals(8.0, c.subtrai(10.0, 2.0));
    assertEquals(-8.0, c.subtrai(2.0, 10.0));
  }

  @Test
  void testMultiplica() {
    assertEquals(10.0, c.multiplica(2.0, 5.0));
    assertEquals(-10.0, c.multiplica(10.0, -1.0));
    assertEquals(0.0, c.multiplica(2.0, 0.0));
    assertEquals(5.0, c.multiplica(10.0, 0.5));
  }

  @Test
  void testDivide() {
    assertEquals(10.0, c.divide(100.0, 10.0));
    assertEquals(4.0, c.divide(8.0, 2.0));
  }

  @Test
  void testPotencia() {
    assertEquals(8, c.potencia(2, 3));
    assertEquals(1024, c.potencia(2, 10));
    assertEquals(9, c.potencia(3, 2));
  }

  @Test
  void testEhDivisivel() {
    assertTrue(c.ehDivisivel(4, 2));
    assertTrue(c.ehDivisivel(10, 5));
    assertFalse(c.ehDivisivel(7, 2));
  }

  @Test
  void testRaizQuadrada() {
    assertEquals(3.0, c.raizQuadrada(9));
    assertEquals(2.0, c.raizQuadrada(4));
    assertEquals(7.0, c.raizQuadrada(49));
  }

  @Test
  void testEhPrimo() {
    assertTrue(c.ehPrimo(2));
    assertFalse(c.ehPrimo(4));
    assertTrue(c.ehPrimo(3));
    assertFalse(c.ehPrimo(6));
    assertTrue(c.ehPrimo(5));
    assertFalse(c.ehPrimo(15));
    assertTrue(c.ehPrimo(7));
    assertTrue(c.ehPrimo(11));
    assertTrue(c.ehPrimo(17));
    assertFalse(c.ehPrimo(21));
  }
  
  @Test
  void testMaior() {
    assertEquals(4.0, c.maior(4.0, 2.0));
    assertEquals(8.0, c.maior(4.0, 8.0));
  }
  
  @Test
  void testMenor() {
    assertEquals(2.0, c.menor(4.0, 2.0));
    assertEquals(4.0, c.menor(4.0, 8.0));
  }
}
