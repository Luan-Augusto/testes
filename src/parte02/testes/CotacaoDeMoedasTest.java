package parte02.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte02.CotacaoDeMoedas;
import parte02.MoedaDesconhecidaException;

class CotacaoDeMoedasTest {

  @Test
  void testConverteDolarParaReal() throws MoedaDesconhecidaException {
    assertEquals(530.0, CotacaoDeMoedas.converte(CotacaoDeMoedas.DOLAR, CotacaoDeMoedas.REAL, 100.0));
  }

  @Test
  void testConverteDolarParaEuro() throws MoedaDesconhecidaException {
    assertEquals(84.0, CotacaoDeMoedas.converte(CotacaoDeMoedas.DOLAR, CotacaoDeMoedas.EURO, 100.0));    
  }
  
  @Test
  void testConverteEuroParaReal() throws MoedaDesconhecidaException {
    assertEquals(627.0, CotacaoDeMoedas.converte(CotacaoDeMoedas.EURO, CotacaoDeMoedas.REAL, 100.0));    
  }

  @Test
  void testConverteEuroParaDolar() throws MoedaDesconhecidaException {
    assertEquals(118.0, CotacaoDeMoedas.converte(CotacaoDeMoedas.EURO, CotacaoDeMoedas.DOLAR, 100.0));    
  }
  
  @Test
  void testConverteRealParaDolar() throws MoedaDesconhecidaException {
    assertEquals(19.0, CotacaoDeMoedas.converte(CotacaoDeMoedas.REAL, CotacaoDeMoedas.DOLAR, 100.0));    
  }
  
  @Test
  void testConverteRealParaEuro() throws MoedaDesconhecidaException {
    assertEquals(16.0, CotacaoDeMoedas.converte(CotacaoDeMoedas.REAL, CotacaoDeMoedas.EURO, 100.0));    
  }

  @Test
  void testConverteMoedaInvalida() throws MoedaDesconhecidaException {
    // Ao converter de dólar para uma moeda inválida, é para lançar exceção
    Exception e1 = assertThrows(MoedaDesconhecidaException.class, () -> {
      CotacaoDeMoedas.converte(CotacaoDeMoedas.DOLAR, -1, 100.0);
    });
    assertNotNull(e1);
    
    // Ao converter de uma moeda inválida para dólar, é para lançar uma exceção
    Exception e2 = assertThrows(MoedaDesconhecidaException.class, () -> {
      CotacaoDeMoedas.converte(3, CotacaoDeMoedas.DOLAR, 100.0);
    });
    assertNotNull(e2);
  }
}
