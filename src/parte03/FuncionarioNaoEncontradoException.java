package parte03;

public class FuncionarioNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String cpf) {
		super("Não foi encontrado um funcionário com o CPF " + cpf);
	}
}