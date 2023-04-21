package practica2_MarcelinoGil;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	/**
	 * This test compares the output of the mainMenu method using
	 * ByteArrayOutputStream with the original message. It seems like a useless test
	 * since the expected output is preset in the program and there are no
	 * varaibles. However, I had to learn about ByteArrayOutputStream to collect the
	 * console message, which could come in handy in other programs.
	 * 
	 * I also learnt that println uses "\r\n" at the end of each line in windows,
	 * and only \n in UNIX OS's, which in this case was also represented with
	 * System.lineSeparator().
	 */
	@Test
	public void testMainMenu() {

		String expectedOutput;

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		System.setOut(new PrintStream(outContent));

		Utilities.mainMenu();

		expectedOutput = "\u001B[107m" + "\u001B[32m" + "+--Marcelino Gil Nombela CRUD ArrayList System--+"
				+ System.lineSeparator() + "\u001B[0m" + "\u001B[32m" + "1-Create" + System.lineSeparator()
				+ "\u001B[32m" + "2-Find/read" + System.lineSeparator() + "\u001B[32m" + "3-Update/Modify"
				+ System.lineSeparator() + "\u001B[32m" + "4-Remove" + System.lineSeparator() + "\u001B[32m"
				+ "5-Exit program" + System.lineSeparator() + "\u001B[0m" + System.lineSeparator();
		assertEquals(outContent.toString(), expectedOutput);
	}

	/** This method is not implemented since it's deprecated */
	@Test
	public void testGetInt() {
		// deprecated
	}

	/**
	 * This method tests if console input equals abc, so to test this properly abc
	 * must be inserted in the console. For some reason I dont understand, the
	 * message "Write abc" wont be shown in the console.
	 */
	@Test
	public void testGetString() {
		String returnedString = "";
		String test = "abc";
		String message = "Write abc";
		// Console output is not shown in JUnit classes, write abc to check if its
		// propertly collected by the method.
		returnedString = Utilities.getString("Write abc");

		assertTrue(returnedString.equals(test));
	}

	/**
	 * areNumbers returns true or false if a String is made of numbers and only
	 * numbers, otherwise it will return false.
	 */
	@Test
	public void testAreNumbers() {
		String input1 = "123FOUR";
		String input2 = "1234";

		assertFalse(Utilities.areNumbers(input1));
		assertTrue(Utilities.areNumbers(input2));
	}

	/** Checks if return is between min and max values, both included. */
	@Test
	public void testGetIntBetween() {
		int min = 1;
		int max = 10;
		int input;
		String message = "Introduce un número entre " + min + " y " + max + ": ";

		input = Utilities.getIntBetween(min, max, message);
		assertTrue(input >= min && input <= max);
	}

	/**
	 * This test will fail if the Char received is neither of the two characters
	 * allowed.
	 */
	@Test
	void testGetCharMenu() {
		char receivedChar;

		receivedChar = Utilities.getCharMenu('y', 'n', "getCharMenuTest:");
		if (receivedChar != 'y' && receivedChar != 'n') {
			fail("Returned value is invalid");
		}
	}

}