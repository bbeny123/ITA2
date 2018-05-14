package pl.beny;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
      assertEquals("empty", 0, Calculator.add(""));
      assertEquals("0", 0, Calculator.add("0"));
      assertEquals("1", 1, Calculator.add("1"));
      assertEquals("2", 2, Calculator.add("2"));
      assertEquals("100", 100, Calculator.add("100"));
      assertEquals("0,1", 1, Calculator.add("0,1"));
      assertEquals("0,100", 100, Calculator.add("0,100"));
      assertEquals("1,1", 2, Calculator.add("1,1"));
      assertEquals("1,100", 101, Calculator.add("1,100"));
      assertEquals("2,2", 4, Calculator.add("2,2"));
      assertEquals("2,100", 102, Calculator.add("2,100"));
      assertEquals("2,2,2,4,1", 11, Calculator.add("2,2,2,4,1"));
      assertEquals("2,100,1,3,2,4,5,1", 118, Calculator.add("2,100,1,3,2,4,5,1"));      
      assertEquals("2\n2,2\n4,1", 11, Calculator.add("2\n2,2\n4,1"));
      assertEquals("2,100,1\n3,2,4,5\n1", 118, Calculator.add("2,100,1\n3,2,4,5\n1"));      
    //    assertThat("2", Calculator.(2), is(Collections.singletonList(2)));
    }
}
