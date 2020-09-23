package parte01;

/**
 * Essa classe implementa uma lâmpada inteligente para um sistema de smart home.
 */
public class Lampada {
	private boolean ligada;
	private String nome;

	public Lampada(String nome) {
		this.nome = nome;
		this.ligada = false;
	}

	/**
	 * Esse método alterna o estado da lâmpada. Ou seja, se ela está ligada ->
	 * desliga e se estiver desligada -> liga
	 */
	public void alternar() {
		if (this.ligada == false) {
			this.ligada = true;
		} else {
			this.ligada = false;
		}
	}

	public boolean isLigada() {
		return this.ligada;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
