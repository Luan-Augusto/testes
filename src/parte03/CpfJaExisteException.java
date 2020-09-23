package parte03;

public class CpfJaExisteException extends Exception {
	public CpfJaExisteException(String cpf) {
		super("Já existe um funcionário cadastrado com o CPF " + cpf);
	}
}