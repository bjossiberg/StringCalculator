package is.ru.stringcalculator;

public class Calculator {

	public static int add(String string){
		if(string.length() == 0)
			return 0;
		return sum(values(string));
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

	private static String numbers(String string) {
		if(string.startsWith("//"))
			return string.substring(3);
		return string;
	}

	private static String delimiter(String string) {
		if(string.startsWith("//"))
 			return string.substring(2,3);
 		return ",|\n";
	}

	private static String[] values(String string) {
		return numbers(string).split(delimiter(string));
	}
}