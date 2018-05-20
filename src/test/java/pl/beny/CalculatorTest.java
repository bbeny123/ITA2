package pl.beny;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class CalculatorTest {

    @Test
    public void testAdd() {
        testAdd("", 0);
        testAdd("0", 0);
        testAdd("1", 1);
        testAdd("2", 2);
        testAdd("100", 100);

        testAdd("0,1", 1);
        testAdd("0,100", 100);
        testAdd("1,2", 3);
        testAdd("1,100", 101);
        testAdd("234,1001", 1235);

        testAdd("1,2,3,4,5", 15);
        testAdd("2,56,231,53,23", 365);

        testAdd("1\n2,3\n4,5", 15);
        testAdd("2\n56,231\n53\n23,69", 434);

        testAdd("//;\n1;2;3;4;5", 15);
        testAdd("//;\n2;56;231;53;23", 365);
        testAdd("//:\n2:56:231:53:23:69", 434);

        testNegatives("-2,-4,-100", "-2, -4, -100");
        testNegatives("1,-2,-4,-101", "-2, -4, -101");
        testNegatives("-2,-4\n-5", "-2, -4, -5");
        testNegatives("//;\n-2;100;1;-3;2;4;5;-1", "-2, -3, -1");
    }

    private void testAdd(String numbers, int expected) {
        assertThat(Calculator.add(numbers), is(expected));
    }

    private void testNegatives(String numbers, String negatives) {
        try {
            Calculator.add(numbers);
            fail("Expected an Exception to be thrown");
        } catch (NumberFormatException ex) {
            assertThat(ex.getMessage(), is("negatives not allowed: " + negatives));
        }
    }
}
