package parte02.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte02.Loja;
import parte02.Produto;

class LojaTest {

  @Test
  void testAdicionarProduto() {
    Loja l = new Loja("Minha Farmácia");
    
    Produto p1 = new Produto("Vitamina C", 10.0);
    Produto p2 = new Produto("Sonrisal", 1.50);
    
    l.adicionarProduto(p1);
    l.adicionarProduto(p2);
    
    assertNotNull(l.getProdutos());
    assertTrue(l.getProdutos().contains(p1));
    assertTrue(l.getProdutos().contains(p2));
  }

  @Test
  void testGetQuantidadeDeProdutos() {
    Loja l = new Loja("Açougue");
    
    l.adicionarProduto(new Produto("Carne de Sol Kg", 40.0));
    l.adicionarProduto(new Produto("Linguiça Kg", 20.0));
    l.adicionarProduto(new Produto("Coração de Galinha Kg", 15.0));
    
    assertEquals(3, l.getQuantidadeDeProdutos());
  }

  @Test
  void testGetProdutoMaisBarato() {
    Loja l = new Loja("Computadores e Cia");
    
    Produto mouse = new Produto("Mouse", 50.0);
    Produto monitor = new Produto("Monitor LCD", 200.0);
    Produto filtroDeLinha = new Produto("Filtro de Linha", 40.0);
    
    l.adicionarProduto(mouse);
    l.adicionarProduto(monitor);
    l.adicionarProduto(filtroDeLinha);
    
    assertEquals(filtroDeLinha, l.getProdutoMaisBarato());
  }

  @Test
  void testGetProdutoMaisCaro() {
    Loja l = new Loja("Computadores e Cia");
    
    Produto mouse = new Produto("Mouse", 50.0);
    Produto monitor = new Produto("Monitor LCD", 200.0);
    Produto filtroDeLinha = new Produto("Filtro de Linha", 40.0);
    
    l.adicionarProduto(mouse);
    l.adicionarProduto(monitor);
    l.adicionarProduto(filtroDeLinha);
    
    assertEquals(monitor, l.getProdutoMaisCaro());
  }

  @Test
  void testGetValorTotalLoja() {
    Loja l = new Loja("Computadores e Cia");
    
    l.adicionarProduto(new Produto("Mouse", 50.0));
    l.adicionarProduto(new Produto("Monitor LCD", 200.0));
    l.adicionarProduto(new Produto("Filtro de Linha", 40.0));
    
    assertEquals(290.0, l.getValorTotalLoja());
  }

  @Test
  void testGetValorMedioDosProdutos() {
    Loja l = new Loja("Computadores e Cia");
    
    l.adicionarProduto(new Produto("Mouse", 60.0));
    l.adicionarProduto(new Produto("Monitor LCD", 200.0));
	l.adicionarProduto(new Produto("Filtro de Linha", 40.0));

}
}
