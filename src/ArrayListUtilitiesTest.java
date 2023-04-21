package practica2_MarcelinoGil;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ArrayListUtilitiesTest {

	/**
	 * This test uses the ByteARrayOutputStream object to collect the output from
	 * the console. To do so, I insert the output with System.setOut and
	 * PrintStream(collector)
	 * 
	 * Once we do this, we can use the data collected shown in console and compare
	 * it with the message we want to be the output: "Tech number 1: MySQL\n"
	 * 
	 * There is another important thing to mention. println uses both \r and \n to
	 * go to the next line, so I had to add those chars in order to properly compare
	 * the expected console output with the actual output form the method
	 * testShowNames.
	 * 
	 * @see ArrayListUtilities#showNames(ArrayList)
	 */
	@Test
	public void testShowNames() {
		
		String expectedOutput;
		ArrayList<Technology> arraylist = new ArrayList<Technology>();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outContent));
		
		arraylist.add(new Technology("MySQL", "DBMS", "Store data", 1995, "MIT"));

		ArrayListUtilities.showNames(arraylist);

		// To properly compare both Strnigs, \r\n must be added since println uses them.
		expectedOutput = "Tech number 1: MySQL\r\n";

		assertEquals(expectedOutput, outContent.toString());
	}
}