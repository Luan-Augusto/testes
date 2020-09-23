package parte03;

public class FuncionarioHorista extends Funcionario {

	/**
	 * Um funcionário horista possui um contrato que estabelece um valor para a hora
	 * trabalhada. O salário será calculado multiplicando o valor da hora pelo
	 * número de horas trabalhadas naquele mês.
	 */
	private double valorHora;
	private int horasTrabalhadasNoMes;

	public FuncionarioHorista(String cpf, String nome, double valorHora) {
		super(cpf, nome);
		this.valorHora = valorHora;
	}

//	public double getValorHora() {
//		return this.valorHora * horasTrabalhadasNoMes;
//	}

//	public void setValorHora(double valorHora) {
//		this.valorHora *= horasTrabalhadasNoMes;
//	}

//	public int getHorasTrabalhadasNoMes() {
//		return this.horasTrabalhadasNoMes;
//	}	

	/**
	 * Esse método define a quantidade de horas trabalhadas no último mês. Essas
	 * horas devem ser usadas para calcular o salário.
	 */
	public void setHorasTrabalhadasNoMes(int horasTrabalhadasNoMes) {
		this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
	}

	public double getSalario() {
		return valorHora * horasTrabalhadasNoMes;
	}
}
