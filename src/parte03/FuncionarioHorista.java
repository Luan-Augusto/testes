package parte03;

public class FuncionarioHorista extends Funcionario {

	/**
	 * Um funcion�rio horista possui um contrato que estabelece um valor para a hora
	 * trabalhada. O sal�rio ser� calculado multiplicando o valor da hora pelo
	 * n�mero de horas trabalhadas naquele m�s.
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
	 * Esse m�todo define a quantidade de horas trabalhadas no �ltimo m�s. Essas
	 * horas devem ser usadas para calcular o sal�rio.
	 */
	public void setHorasTrabalhadasNoMes(int horasTrabalhadasNoMes) {
		this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
	}

	public double getSalario() {
		return valorHora * horasTrabalhadasNoMes;
	}
}
