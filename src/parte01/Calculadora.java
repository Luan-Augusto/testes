package parte01;

public class Calculadora {
	/**
	 * Esse método soma dois números
	 * 
	 * @return Retorna a soma: A + B
	 */
	public double soma(double a, double b) {
		return a + b;
	}

	/**
	 * Esse método subtrai dois números
	 * 
	 * @return Retorna a subtração: A - B
	 */
	public double subtrai(double a, double b) {
		return a - b;
	}

	/**
	 * Esse método multiplica dois números
	 * 
	 * @return Retorna a multplicação: A x B
	 */
	public double multiplica(double a, double b) {
		return a * b;
	}

	/**
	 * Esse método divide dois números
	 * 
	 * @return Retorna a divisão: A / B
	 */
	public double divide(double a, double b) {
		return a / b;
	}

	/**
	 * Esse método calcula uma potência
	 * 
	 * @return Retorna o número A elevado à potência B
	 */
	public int potencia(int a, int b) {
		return (int) Math.pow(a, b);
	}

	/**
	 * Esse método diz se um número é divisível pelo outro.
	 * 
	 * @return Retorna true se A é divisível por B ou false, caso contrário.
	 */
	public boolean ehDivisivel(int a, int b) {
		return a % b == 0;
	}

	/**
	 * Esse método calcula uma raiz quadrada
	 * 
	 * @return Retorna a raiz quadrada de A
	 */
	public double raizQuadrada(int a) {
		return Math.sqrt(a);
	}

	/**
	 * Esse método diz se um número A é primo ou não. Números primos são aqueles que
	 * só são divisíveis por si mesmo ou por 1.
	 * 
	 * @return Retorna true se A é primo ou false, caso contrário.
	 */
	public boolean ehPrimo(int a) {
		for (int j = 2; j < a; j++) {
			if (a % j == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Esse método retorna o maior número entre A e B
	 */
	public double maior(double a, double b) {
		return (a > b) ? a : b;
	}

	/**
	 * Esse método retorna o menor número entre A e B
	 */
	public double menor(double a, double b) {
		return (a < b) ? a : b;
	}
}
