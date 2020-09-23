package parte03.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parte03.CpfJaExisteException;
import parte03.Empresa;
import parte03.Funcionario;
import parte03.FuncionarioCLT;
import parte03.FuncionarioHorista;
import parte03.FuncionarioNaoEncontradoException;

class EmpresaTest {
	private Empresa empresa;

	@BeforeEach
	void setUp() throws Exception {
		empresa = new Empresa("F�brica de Colch�es");
		empresa.contratar(new FuncionarioCLT("000.000.000-00", "Operario 1", 2000.0));
		empresa.contratar(new FuncionarioCLT("111.111.111-11", "Operario 2", 2500.0));
		empresa.contratar(new FuncionarioCLT("222.222.222-22", "Gerente", 5000.0));
		empresa.contratar(new FuncionarioHorista("333.333.333-33", "Motorista", 18.75));
		empresa.contratar(new FuncionarioHorista("444.444.444-44", "Zelador", 15.0));
	}

	@Test
	void testContratarComSucesso() throws CpfJaExisteException {
		// Nesse caso, � para contratar o funcion�rio sem nenhum problema
		Funcionario diretor = new FuncionarioCLT("555.555.555-55", "Diretor", 8000.0);
		empresa.contratar(diretor);
		assertTrue(empresa.getFuncionarios().contains(diretor));
	}

	@Test
	void testContratarCpfRepetido() throws CpfJaExisteException {
		// Aqui eu espero que ocorra uma exce��o de CPF repetido
		Exception ex = assertThrows(CpfJaExisteException.class, () -> {
			Funcionario diretor = new FuncionarioCLT("000.000.000-00", "Diretor", 8000.0);
			empresa.contratar(diretor);
		});
		assertNotNull(ex);
		assertEquals("J� existe um funcion�rio cadastrado com o CPF 000.000.000-00", ex.getMessage());
	}

	@Test
	void testGetFuncionarioQueExiste() throws FuncionarioNaoEncontradoException {
		// Esse funcion�rio existe
		Funcionario f = empresa.getFuncionario("111.111.111-11");
		assertNotNull(f);
		assertEquals("Operario 2", f.getNome());
	}

	@Test
	void testGetFuncionarioQueNaoExiste() throws FuncionarioNaoEncontradoException {
		// Tentando procurar um funcion�rio que n�o existe
		Exception ex = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
			empresa.getFuncionario("666.666.666-66");
		});
		assertNotNull(ex);
		assertEquals("N�o foi encontrado um funcion�rio com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testDemitirFuncionarioQueExiste() throws FuncionarioNaoEncontradoException {
		Funcionario f = empresa.getFuncionario("111.111.111-11");
		assertNotNull(f);
		// Confirma que o funcion�rio existe mesmo
		assertTrue(empresa.getFuncionarios().contains(f));
		// Demite o funcion�rio
		empresa.demitir("111.111.111-11");
		// Confirma que o funcion�rio n�o consta mais na empresa
		assertFalse(empresa.getFuncionarios().contains(f));
	}

	@Test
	void testDemitirFuncionarioQueNaoExiste() throws FuncionarioNaoEncontradoException {
		// Tentando demitir um funcion�rio que n�o existe
		Exception ex = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
			empresa.demitir("666.666.666-66");
		});
		assertEquals("N�o foi encontrado um funcion�rio com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testCalculaSalarioDeFuncionariosQueExistem() throws FuncionarioNaoEncontradoException {
		// Funcion�rios CLT t�m sal�rios fixos
		assertEquals(2000.0, empresa.calculaSalario("000.000.000-00"));
		assertEquals(2500.0, empresa.calculaSalario("111.111.111-11"));
		assertEquals(5000.0, empresa.calculaSalario("222.222.222-22"));
		// O sal�rio de funcion�rios horistas, depente das horas trabalhadas
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		// O funcion�rio trabalhou 160 horas nesse m�s
		f1.setHorasTrabalhadasNoMes(160);
		// Agora, calcula o sal�rio
		assertEquals(3000.0, empresa.calculaSalario("333.333.333-33"));
		// Fazendo o mesmo para o funcion�rio f2
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);
		assertEquals(2520.0, empresa.calculaSalario("444.444.444-44"));
	}

	@Test
	void testCalculaSalarioDeFuncionariosNaoQueExistem() throws FuncionarioNaoEncontradoException {
		// Tentando demitir um funcion�rio que n�o existe
		Exception ex = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
			empresa.calculaSalario("666.666.666-66");
		});
		assertNotNull(ex);
		assertEquals("N�o foi encontrado um funcion�rio com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testCalculaFolhaDePagamento() throws FuncionarioNaoEncontradoException {
		// Antes de calcular a folha de pagamento � necess�rio registrar
		// as horas trabalhadas dos funcion�rios horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		// A folha de pagamento ser� a soma dos sal�rios CLT + horistas
		// 2000 + 2500 + 5000 + 3000 + 2520 = 15020
		assertEquals(15020.0, empresa.calculaFolhaDePagamento());
	}

	@Test
	void testGetFuncionarioQueRecebeMenos() throws FuncionarioNaoEncontradoException {
		// Para saber quem recebe menos, � necess�rio registrar
		// as horas trabalhadas dos funcion�rios horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		Funcionario recebeMenos = empresa.getFuncionario("000.000.000-00");
		assertEquals(recebeMenos, empresa.getFuncionarioQueRecebeMenos());
	}

	@Test
	void testGetFuncionarioQueRecebeMais() throws FuncionarioNaoEncontradoException {
		// Para saber quem recebe mais, � necess�rio registrar
		// as horas trabalhadas dos funcion�rios horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		Funcionario recebeMais = empresa.getFuncionario("000.000.000-00");
		assertEquals(recebeMais, empresa.getFuncionarioQueRecebeMais());
	}

	@Test
	void testGetValorMedioDosSalarios() throws FuncionarioNaoEncontradoException {
		// Para calcular o sal�rio m�dio, � necess�rio registrar
		// as horas trabalhadas dos funcion�rios horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		// Ser� calculada a m�dia dos sal�rios:
		// (2000 + 2500 + 5000 + 3000 + 2520) / 5 = 3004
		assertEquals(3004.0, empresa.getValorMedioDosSalarios());
	}

}
