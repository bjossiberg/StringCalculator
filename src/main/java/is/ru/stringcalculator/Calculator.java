package is.ru.stringcalculator;

public class Calculator {

	public static int add(String string){
		if(string.length() == 0)
			return 0;
		return sum(string.split(","));
	}

	private static int sum(String[] values) {
		int total = 0;
		for (String value : values) {
			total += toInt(value);
		}
		return total;
	}

	private static int toInt(String value) {
		return Integer.parseInt(value);
	}
}