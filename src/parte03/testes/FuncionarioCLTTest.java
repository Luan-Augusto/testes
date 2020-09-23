package parte03.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte03.Funcionario;
import parte03.FuncionarioCLT;

class FuncionarioCLTTest {

  @Test
  void testGetSalario() {
    Funcionario f = new FuncionarioCLT("000.000.000-00", "F1", 1500.00);
    assertEquals(1500.00, f.getSalario());
  }

}
