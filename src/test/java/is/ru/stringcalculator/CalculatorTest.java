package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void EmptyStringTest(){
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void OneNumberTest(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void TwoNumberTest(){
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void MultipleNumberTest(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void AllowNewlineTest(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void AllowDelimiterTest(){
		assertEquals(6, Calculator.add("//;1;2;3"));
	}

	@Test
	public void ExceptionIfNegative(){
		try {
			Calculator.add("2,-4,3,-5");
		} catch (Exception e) {
			assertEquals("Negatives not allowed:-4,-5", e.getMessage());
		}
	}

	@Test
	public void IgnoreNumbersBiggerThan1000(){
		assertEquals(2, Calculator.add("1001,2"));
	}
}