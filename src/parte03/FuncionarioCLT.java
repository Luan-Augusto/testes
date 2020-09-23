package parte03;

/**
 * Um funcionário com contrato CLT, ou carteira assinada, possui um salário
 * fixo.
 */

public class FuncionarioCLT extends Funcionario {
	private double salario;

	public FuncionarioCLT(String cpf, String nome, double salario) {
		super(cpf, nome);
		this.salario = salario;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
