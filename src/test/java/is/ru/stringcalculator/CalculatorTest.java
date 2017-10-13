package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testEmptyString(){
    assertEquals(0,Calculator.add(""));
  }

  @Test
  public void testOneNumber(){
    assertEquals(1,Calculator.add("1"));
  }

  @Test
  public void testTwoNumbers(){
    assertEquals(3,Calculator.add("1,2"));
  }

  @Test
  public void testMultipleNumbers(){
    assertEquals(6,Calculator.add("1,2,3"));
  }

  @Test
  public void testTwoNumbersNewLine(){
    assertEquals(6,Calculator.add("1\n2,3"));
  }

  @Test
  public void testDifferentUsageOfNewLineAndCommas(){
    assertEquals(8,Calculator.add("1,2\n1\n1,2\n1"));
  }

  @Test
  public void testNegativeNumber(){
    Boolean throwEx = false;
    try {
          Calculator.add("-1");
    }
    catch(IllegalArgumentException ex) {
            throwEx = true;
    }
    assertEquals(true,throwEx);
  }

  @Test
  public void testTwoNegativeNumbers(){

    Boolean threwEx = false;
    try {
          Calculator.add("-4,-3");
    }
    catch(IllegalArgumentException ex) {
          threwEx = true;
    }
    assertEquals(true,threwEx);
  }
}
