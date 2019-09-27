package edu.wit.cs.comp1000.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import edu.wit.cs.comp1000.PA3b;
import junit.framework.TestCase;

public class PA3bTestCase extends TestCase {
	
	private void _test(String[] values, String roots, String answer) {
		final String input = String.join(" ", values);
		
		final String output = TestSuite.stringOutput(new String[] {
			"Enter a b c: " +
			roots + ": " + answer + "%n" }, new Object[] {});
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		System.setOut(new PrintStream(outContent));
		
		PA3b.main(new String[] { "foo" });
		assertEquals(output, outContent.toString());
		
		System.setIn(null);
		System.setOut(null);
	}
	
	public void testImagWhole() {
		_test(new String[] {"1", "1", "4"}, "Roots", "imaginary");
	}
	
	public void testImagDec() {
		_test(new String[] {"1.1", "1", "4.1"}, "Roots", "imaginary");
	}
	
	public void testSingle() {
		_test(new String[] {"1", "4", "4"}, "Root", "-2.00");
		_test(new String[] {"1", "-4", "4"}, "Root", "2.00");
	}
	
	public void testTwoWhole() {
		_test(new String[] {"1", "6", "5"}, "Roots", "-5.00, -1.00");
		_test(new String[] {"1", "-6", "5"}, "Roots", "1.00, 5.00");
	}
	
	public void testTwoDec() {
		_test(new String[] {"2", "-5.5", "2.5"}, "Roots", "0.57, 2.18");
		_test(new String[] {"2", "5.5", "2.5"}, "Roots", "-2.18, -0.57");
	}

}
