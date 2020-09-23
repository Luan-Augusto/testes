package parte03;

public class FuncionarioNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String cpf) {
		super("N�o foi encontrado um funcion�rio com o CPF " + cpf);
	}
}