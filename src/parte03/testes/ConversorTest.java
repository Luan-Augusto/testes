package parte03.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte03.Conversor;

class ConversorTest {

  @Test
  void testDoubleParaInt() {
    assertEquals(3, Conversor.doubleParaInt(3.14));
  }

  @Test
  void testIntParaDouble() {
    assertEquals(3.0, Conversor.intParaDouble(3));
  }

  @Test
  void testStringParaInt() {
    assertEquals(3, Conversor.stringParaInt("3"));
  }

  @Test
  void testStringParaDouble() {
    assertEquals(3.14, Conversor.stringParaDouble("3.14"));
  }

  @Test
  void testIntParaString() {
    assertEquals("3", Conversor.intParaString(3));
  }

  @Test
  void testDoubleParaString() {
    assertEquals("3.14", Conversor.doubleParaString(3.14));
  }

}
