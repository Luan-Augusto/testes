package parte02;

public class CotacaoDeMoedas {
	public static final int REAL = 0;
	public static final int DOLAR = 1;
	public static final int EURO = 2;

	// Cotações no dia 11/09/2020
	private static final double realParaDolar = 0.19;
	private static final double realParaEuro = 0.16;
	private static final double euroParaReal = 6.27;
	private static final double dolarParaReal = 5.30;
	private static final double dolarParaEuro = 0.84;
	private static final double euroParaDolar = 1.18;

	public static double converte(int deMoeda, int paraMoeda, double valor) throws MoedaDesconhecidaException {

		if (deMoeda == REAL && paraMoeda == DOLAR) {
			return valor * realParaDolar;
		}

		if (deMoeda == REAL && paraMoeda == EURO) {
			return valor * realParaEuro;
		}

		if (deMoeda == DOLAR && paraMoeda == EURO) {
			return valor * dolarParaEuro;
		}

		if (deMoeda == DOLAR && paraMoeda == REAL) {
			return valor * dolarParaReal;
		}

		if (deMoeda == EURO && paraMoeda == REAL) {
			return valor * euroParaReal;
		}

		if (deMoeda == EURO && paraMoeda == DOLAR) {
			return valor * euroParaDolar;
		}

		throw new MoedaDesconhecidaException();
//	}
	}
}
