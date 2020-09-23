package parte03.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte03.FuncionarioHorista;

class FuncionarioHoristaTest {

  @Test
  void testGetSalario() {
    // Esse funcionário recebe R$ 20,00 por hora
    FuncionarioHorista f = new FuncionarioHorista("111.111.111-11", "F1", 20.0);
    // Vamos supor que ele trabalhe 100 horas esse mês
    f.setHorasTrabalhadasNoMes(100);
    // O salário será R$ 20,00 x 100 = R$ 2.000,00
    assertEquals(2000.0, f.getSalario());
  }

}
