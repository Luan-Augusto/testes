package parte02;

/**
 * Essa classe possui métodos para trabalhar com texto
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
	 * A extensão de um arquivo são seus 3 últimos caracteres. Ex, um arquivo
	 * foto.png, a extensão é png
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
