package parte03;

public class CpfJaExisteException extends Exception {
	public CpfJaExisteException(String cpf) {
		super("J� existe um funcion�rio cadastrado com o CPF " + cpf);
	}
}