package parte01;

public class Pessoa {

	private String nome;
	private int idade;
	private double altura;
	private double peso;

	public Pessoa(String nome, int idade, double altura, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getIMC() {
		// Ex: Peso = 65 Altura = 1,60 IMC = 64 / (1,60 x 1,60) = 25,0
		return peso / (altura * altura);
	}
}
