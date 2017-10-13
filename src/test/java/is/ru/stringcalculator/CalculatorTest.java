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

  @Test
  public void testMultipleNegativeNumbers(){
    Boolean threwEx = false;
    try {
          Calculator.add("-2,-4,\n3,-5");
    }
    catch(IllegalArgumentException ex) {
          threwEx = true;
    }
    assertEquals(true,threwEx);
  }

  @Test
  public void testBigNumber(){
    assertEquals(0,Calculator.add("1001"));
  }

  @Test
  public void testBigNumbers(){
    assertEquals(6,Calculator.add("1,1001,100324,9999,3\n2"));
  }

  @Test
  public void testDelimeter() {
       assertEquals(13, Calculator.add("//[*]\n1*10*2"));
   }

   @Test
   public void testMultpileDelimeters(){
     assertEquals(25, Calculator.add("//[%+/&]\n8%+/&5%+/&12"));
   }

   @Test
   public void testDelemieterWithNegatives() {
     Boolean threwEx = false;
     try {
        Calculator.add("//[*]\n1*-7*-9");
     }
     catch(IllegalArgumentException ex) {
           threwEx = true;
     }
     assertEquals(true,threwEx);
    }

    @Test
    public void testMultipleDelemietersWithNegatives() {
      Boolean threwEx = false;
      try {
         Calculator.add("//[***+]\n1***+-10***+-2");
      }
      catch(IllegalArgumentException ex) {
            threwEx = true;
      }
      assertEquals(true,threwEx);
     }

     @Test
     public void testComplicated(){
       assertEquals(1988, Calculator.add("//[*+--+*]\n100000*+--+*988*+--+*999*+--+*0*+--+*1"));
     }
}
