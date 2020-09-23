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
		empresa = new Empresa("Fábrica de Colchões");
		empresa.contratar(new FuncionarioCLT("000.000.000-00", "Operario 1", 2000.0));
		empresa.contratar(new FuncionarioCLT("111.111.111-11", "Operario 2", 2500.0));
		empresa.contratar(new FuncionarioCLT("222.222.222-22", "Gerente", 5000.0));
		empresa.contratar(new FuncionarioHorista("333.333.333-33", "Motorista", 18.75));
		empresa.contratar(new FuncionarioHorista("444.444.444-44", "Zelador", 15.0));
	}

	@Test
	void testContratarComSucesso() throws CpfJaExisteException {
		// Nesse caso, é para contratar o funcionário sem nenhum problema
		Funcionario diretor = new FuncionarioCLT("555.555.555-55", "Diretor", 8000.0);
		empresa.contratar(diretor);
		assertTrue(empresa.getFuncionarios().contains(diretor));
	}

	@Test
	void testContratarCpfRepetido() throws CpfJaExisteException {
		// Aqui eu espero que ocorra uma exceção de CPF repetido
		Exception ex = assertThrows(CpfJaExisteException.class, () -> {
			Funcionario diretor = new FuncionarioCLT("000.000.000-00", "Diretor", 8000.0);
			empresa.contratar(diretor);
		});
		assertNotNull(ex);
		assertEquals("Já existe um funcionário cadastrado com o CPF 000.000.000-00", ex.getMessage());
	}

	@Test
	void testGetFuncionarioQueExiste() throws FuncionarioNaoEncontradoException {
		// Esse funcionário existe
		Funcionario f = empresa.getFuncionario("111.111.111-11");
		assertNotNull(f);
		assertEquals("Operario 2", f.getNome());
	}

	@Test
	void testGetFuncionarioQueNaoExiste() throws FuncionarioNaoEncontradoException {
		// Tentando procurar um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
			empresa.getFuncionario("666.666.666-66");
		});
		assertNotNull(ex);
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testDemitirFuncionarioQueExiste() throws FuncionarioNaoEncontradoException {
		Funcionario f = empresa.getFuncionario("111.111.111-11");
		assertNotNull(f);
		// Confirma que o funcionário existe mesmo
		assertTrue(empresa.getFuncionarios().contains(f));
		// Demite o funcionário
		empresa.demitir("111.111.111-11");
		// Confirma que o funcionário não consta mais na empresa
		assertFalse(empresa.getFuncionarios().contains(f));
	}

	@Test
	void testDemitirFuncionarioQueNaoExiste() throws FuncionarioNaoEncontradoException {
		// Tentando demitir um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
			empresa.demitir("666.666.666-66");
		});
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testCalculaSalarioDeFuncionariosQueExistem() throws FuncionarioNaoEncontradoException {
		// Funcionários CLT têm salários fixos
		assertEquals(2000.0, empresa.calculaSalario("000.000.000-00"));
		assertEquals(2500.0, empresa.calculaSalario("111.111.111-11"));
		assertEquals(5000.0, empresa.calculaSalario("222.222.222-22"));
		// O salário de funcionários horistas, depente das horas trabalhadas
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		// O funcionário trabalhou 160 horas nesse mês
		f1.setHorasTrabalhadasNoMes(160);
		// Agora, calcula o salário
		assertEquals(3000.0, empresa.calculaSalario("333.333.333-33"));
		// Fazendo o mesmo para o funcionário f2
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);
		assertEquals(2520.0, empresa.calculaSalario("444.444.444-44"));
	}

	@Test
	void testCalculaSalarioDeFuncionariosNaoQueExistem() throws FuncionarioNaoEncontradoException {
		// Tentando demitir um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoEncontradoException.class, () -> {
			empresa.calculaSalario("666.666.666-66");
		});
		assertNotNull(ex);
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testCalculaFolhaDePagamento() throws FuncionarioNaoEncontradoException {
		// Antes de calcular a folha de pagamento é necessário registrar
		// as horas trabalhadas dos funcionários horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		// A folha de pagamento será a soma dos salários CLT + horistas
		// 2000 + 2500 + 5000 + 3000 + 2520 = 15020
		assertEquals(15020.0, empresa.calculaFolhaDePagamento());
	}

	@Test
	void testGetFuncionarioQueRecebeMenos() throws FuncionarioNaoEncontradoException {
		// Para saber quem recebe menos, é necessário registrar
		// as horas trabalhadas dos funcionários horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		Funcionario recebeMenos = empresa.getFuncionario("000.000.000-00");
		assertEquals(recebeMenos, empresa.getFuncionarioQueRecebeMenos());
	}

	@Test
	void testGetFuncionarioQueRecebeMais() throws FuncionarioNaoEncontradoException {
		// Para saber quem recebe mais, é necessário registrar
		// as horas trabalhadas dos funcionários horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		Funcionario recebeMais = empresa.getFuncionario("000.000.000-00");
		assertEquals(recebeMais, empresa.getFuncionarioQueRecebeMais());
	}

	@Test
	void testGetValorMedioDosSalarios() throws FuncionarioNaoEncontradoException {
		// Para calcular o salário médio, é necessário registrar
		// as horas trabalhadas dos funcionários horistas.
		FuncionarioHorista f1 = (FuncionarioHorista) empresa.getFuncionario("333.333.333-33");
		f1.setHorasTrabalhadasNoMes(160);
		FuncionarioHorista f2 = (FuncionarioHorista) empresa.getFuncionario("444.444.444-44");
		f2.setHorasTrabalhadasNoMes(168);

		// Será calculada a média dos salários:
		// (2000 + 2500 + 5000 + 3000 + 2520) / 5 = 3004
		assertEquals(3004.0, empresa.getValorMedioDosSalarios());
	}

}
