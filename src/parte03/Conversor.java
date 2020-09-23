package parte03;

public class Conversor {
	public static int doubleParaInt(double a) {
		return (int) a;
	}

	public static double intParaDouble(int a) {
		return (double) a;
	}

	public static int stringParaInt(String str) {
		return Integer.parseInt(str);
	}

	public static double stringParaDouble(String str) {
		return Double.parseDouble(str);

	}

	public static String intParaString(int a) {
		return String.valueOf(a);
	}

	public static String doubleParaString(double a) {
		return String.valueOf(a);
	}
}
