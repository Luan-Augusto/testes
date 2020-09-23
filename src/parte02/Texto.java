package parte02;

/**
 * Essa classe possui m�todos para trabalhar com texto
 */
public class Texto {
	private String texto;

	public Texto(String texto) {
		this.texto = texto;
	}

	public String paraMaiusculas() {
		return this.texto.toUpperCase();
	}

	public String paraMinusculas() {
		return this.texto.toLowerCase();
	}

	public int getQuantidadeDeCaracteres() {
		return texto.length();
	}

	/**
	 * A extens�o de um arquivo s�o seus 3 �ltimos caracteres. Ex, um arquivo
	 * foto.png, a extens�o � png
	 */
	public String getExtensao() {
		return this.texto.substring(texto.length() - 3);
	}

	public boolean ehIgual(String outroTexto) {
		return texto.equals(outroTexto);
	}

	public boolean comecaCom(String prefixo) {
		return this.texto.startsWith(prefixo);
	}

	public boolean terminaCom(String sufixo) {
		return this.texto.endsWith(sufixo);
	}
}
