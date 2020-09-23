package parte03;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nome;
	private List<Funcionario> funcionarios;

	public Empresa(String nome) {
		this.nome = nome;
		this.funcionarios = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void contratar(Funcionario f) throws CpfJaExisteException {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(f.getCpf())) {
				throw new CpfJaExisteException(f.getCpf());
			}
		}
		funcionarios.add(f);
	}

	/**
	 * Retorna o funcionário com o CPF informado
	 * 
	 * @throws FuncionarioNaoEncontradoException caso não exista um funcionário com
	 *                                           o CPF informado
	 */
	public Funcionario getFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		for (Funcionario f : funcionarios) {
			if (f.getCpf() == cpf) {
				return f;
			}
		}
		throw new FuncionarioNaoEncontradoException(cpf);
	}

	/**
	 * Demite o funcionário com o CPF informado
	 * 
	 * @throws FuncionarioNaoEncontradoException caso não exista um funcionário com
	 *                                           o CPF informado
	 */
	public void demitir(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario f = null;
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf() == cpf) {
				f = funcionario;
			}
		}
		if (funcionarios.indexOf(f) != -1) {
			funcionarios.remove(f);
		} else {
			throw new FuncionarioNaoEncontradoException(cpf);
		}
	}

	/**
	 * Calcula o salário do funcionário com o CPF informado
	 * 
	 * @throws FuncionarioNaoEncontradoException caso não exista um funcionário com
	 *                                           o CPF informado
	 */
	public double calculaSalario(String cpf) throws FuncionarioNaoEncontradoException {
		for (Funcionario f : funcionarios) {
			if (f.getCpf() == cpf) {
				return f.getSalario();
			}
		}
		throw new FuncionarioNaoEncontradoException(cpf);
	}

	/**
	 * Calcula o valor total pago na folha de pagamento da empresa.
	 */
	public double calculaFolhaDePagamento() {
		// A folha de pagamento será a soma dos salários CLT + horistas
		// 2000 + 2500 + 5000 + 3000 + 2520 = 15020
		double total = 0;
		for (Funcionario f : funcionarios) {
			total += f.getSalario();
		}
		return total;
	}

	public Funcionario getFuncionarioQueRecebeMenos() {
		return procurarProfessor();
	}

	public Funcionario getFuncionarioQueRecebeMais() {
		return procurarFuncionarioQueRecebeMenos();
	}

	public double getValorMedioDosSalarios() {
		double total = 0;
		for (Funcionario f : funcionarios) {
			total += f.getSalario() / 5;
		}
		return total;
	}

//	Metodos os quais simplifiquei 
	private Funcionario procurarProfessor() {
		Funcionario funcionario = null;
		for (Funcionario f : funcionarios) {
			if (funcionario == null) {
				funcionario = f;
			} else if (f.getSalario() < f.getSalario()) {
				funcionario = f;
			}
		}
		return funcionario;
	}

	private Funcionario procurarFuncionarioQueRecebeMenos() {
		Funcionario funcionario = null;
		for (Funcionario f : funcionarios) {
			if (funcionario == null) {
				funcionario = f;
			} else if (f.getSalario() > f.getSalario()) {
				funcionario = f;
			}
		}
		return funcionario;
	}
}