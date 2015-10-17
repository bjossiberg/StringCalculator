package is.ru.stringcalculator;

public class Calculator {

	public static int add(String string){
		if(string.length() == 0)
			return 0;
		findNegativeNumbers(values(string));
		return sum(values(string));
	}

	private static int sum(String[] values) {
		int total = 0;
		for (String value : values) {
			if(toInt(value) > 1000) {
				continue;
			}
			total += toInt(value);
		}
		return total;
	}

	private static int toInt(String value) {
		return Integer.valueOf(value);
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

	private static void findNegativeNumbers(String[] values) {
		String negativeNumbers = "";
		for (String value : values) {
			if(toInt(value) < 0)
				negativeNumbers += ","+value;
		}
		if(negativeNumbers.length() > 0)
			throw new RuntimeException("Negatives not allowed:" + negativeNumbers.substring(1));

	}
}