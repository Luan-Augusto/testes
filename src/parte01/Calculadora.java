package parte01;

public class Calculadora {
	/**
	 * Esse m�todo soma dois n�meros
	 * 
	 * @return Retorna a soma: A + B
	 */
	public double soma(double a, double b) {
		return a + b;
	}

	/**
	 * Esse m�todo subtrai dois n�meros
	 * 
	 * @return Retorna a subtra��o: A - B
	 */
	public double subtrai(double a, double b) {
		return a - b;
	}

	/**
	 * Esse m�todo multiplica dois n�meros
	 * 
	 * @return Retorna a multplica��o: A x B
	 */
	public double multiplica(double a, double b) {
		return a * b;
	}

	/**
	 * Esse m�todo divide dois n�meros
	 * 
	 * @return Retorna a divis�o: A / B
	 */
	public double divide(double a, double b) {
		return a / b;
	}

	/**
	 * Esse m�todo calcula uma pot�ncia
	 * 
	 * @return Retorna o n�mero A elevado � pot�ncia B
	 */
	public int potencia(int a, int b) {
		return (int) Math.pow(a, b);
	}

	/**
	 * Esse m�todo diz se um n�mero � divis�vel pelo outro.
	 * 
	 * @return Retorna true se A � divis�vel por B ou false, caso contr�rio.
	 */
	public boolean ehDivisivel(int a, int b) {
		return a % b == 0;
	}

	/**
	 * Esse m�todo calcula uma raiz quadrada
	 * 
	 * @return Retorna a raiz quadrada de A
	 */
	public double raizQuadrada(int a) {
		return Math.sqrt(a);
	}

	/**
	 * Esse m�todo diz se um n�mero A � primo ou n�o. N�meros primos s�o aqueles que
	 * s� s�o divis�veis por si mesmo ou por 1.
	 * 
	 * @return Retorna true se A � primo ou false, caso contr�rio.
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
	 * Esse m�todo retorna o maior n�mero entre A e B
	 */
	public double maior(double a, double b) {
		return (a > b) ? a : b;
	}

	/**
	 * Esse m�todo retorna o menor n�mero entre A e B
	 */
	public double menor(double a, double b) {
		return (a < b) ? a : b;
	}
}
