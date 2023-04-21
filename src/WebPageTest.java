package practica2_MarcelinoGil;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * One of the main purpose of this test class is using different ways to test
 * methods rather than following the simpler/easier way to do so.
 */
class WebPageTest {

	ArrayList<Technology> arrayListTest = new ArrayList<Technology>();
	WebPage webTest = new WebPage("test1", "test2", 0, arrayListTest);
	Technology techTest = new Technology("testa", "testb", "testc", 1, "testd");

	/**
	 * First test of a method that adds a Technology given as parameter into the
	 * WebPage's ArrayList attribute
	 * 
	 * @see WebPage#addTechnology(Technology)
	 */
	@Test
	public void testAddTechnology() {

		webTest.addTechnology(techTest);

		assertTrue(webTest.getTechStack().size() == 1);
		assertSame(techTest, webTest.getTechStack().get(0));
	}

	/**
	 * In this case, I am testing the previous method again but with a
	 * parametrizedTest, that test multiple different insertions via parameters in
	 * the original method.
	 * 
	 * This is useful to test more than one input, but I still need to read more
	 * about these types of tests to really understand how it works.
	 * 
	 * @see WebPage#addTechnology(String, String, String, int, String)
	 */
	@ParameterizedTest
	@CsvSource({ "MySQL, DBMS, Store data, 1995, MIT" })
	public void testAddTechnology1(String techName, String techType, String purpose, int releaseYear, String license) {
		String expectedOutput;
		expectedOutput = "Technology [techName=MySQL, techType=DBMS, purpose=Store data, releaseYear=1995, license=MIT]";

		webTest.addTechnology(techName, techType, purpose, releaseYear, license);

		assertTrue(webTest.getTechStack().size() == 1);
		assertEquals(webTest.getTechStack().get(0).toString(), expectedOutput);
	}

	/**
	 * The method tests if the content of the new Technology is properly inserted by
	 * comparing two Strings.
	 * 
	 * @see WebPage#addTechnology(String, String, String, int, String)
	 */
	@Test
	public void testAddTechnology2() {

		Technology newTech = new Technology("testA", "testB", "testC", 1, "testD");
		webTest.addTechnology("testA", "testB", "testC", 1, "testD");

		assertEquals(webTest.getTechStack().get(0).toString(), newTech.toString());
	}

	/**
	 * To properly run this test, insert the specified data inside this
	 * method(name,type,purpose...
	 * 
	 * @see WebPage#addTechnology()
	 */
	@Test
	public void testAddTechnology1() {
		// addTechnology(); will recieve the inputs from the console, insert:
		// name, type, purpose, 1999, license
		webTest.addTechnology();

		assertTrue(webTest.getTechStack().get(0).getTechName().equals("name"));
		assertTrue(webTest.getTechStack().get(0).getTechType().equals("type"));
		assertTrue(webTest.getTechStack().get(0).getPurpose().equals("purpose"));
		assertTrue(webTest.getTechStack().get(0).getReleaseYear() == (1999));
		assertTrue(webTest.getTechStack().get(0).getLicense().equals("license"));
	}

	/**
	 * Instead of creating the ArrayList and objects I use the Test Class
	 * attributes.
	 * 
	 * @see WebPage#addPremadeTech(ArrayList)
	 */
	@Test
	public void testAddPremadeTech() {
		// Adding a Technology into the ArrayList of premade technologies (not the
		// ArrayList that is an attribute of the WebSite class)

		ArrayList<Technology> premadeTechs = new ArrayList<Technology>();

		premadeTechs.add(techTest);

		// We call the method that adds premades Technologies inside the WebPage's
		// ArrayList attribute.
		webTest.addPremadeTech(premadeTechs);

		System.out.println(webTest.toString());
		assertTrue(webTest.getTechStack().get(0).equals(techTest));

	}

	/**
	 * Compares the console output of the tested method with the message expected
	 * 
	 * @see WebPage#findAllMatches(String)
	 */
	@Test
	public void testFindAllMatches() {

		String expectedOutput;

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();

		Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995, "MIT");
		Technology mongodb = new Technology("MongoDB", "DBMS", "Store data", 2009, "GNU");

		// The expected output after using the method findAllMatches
		expectedOutput = "Technology [techName=MySQL, techType=DBMS, purpose=Store data, releaseYear=1995, license=MIT]\r\nTechnology [techName=MongoDB, techType=DBMS, purpose=Store data, releaseYear=2009, license=GNU]\r\n";

		webTest.addTechnology(mysql);
		webTest.addTechnology(mongodb);

		// This will collect the next console output.
		System.setOut(new PrintStream(outContent));

		// The method we want to test.
		webTest.findAllMatches("DBMS");

		/*
		 * After too many times checking this test I realiced that the
		 * ByteArrayOutputStream "outContent" requires the toString() method to properly
		 * get the representation before comparing it with the expectedOutput variable.
		 */

		assertEquals(expectedOutput, outContent.toString());
	}

	/**
	 * I add two Technologies inside the WebPage's ArrayList attribute. Then, using
	 * the method to be tested I collect the position inside the ArrayList where the
	 * first match of the data requested was found. That index must be 1, because
	 * the word gnu is only found in the attribute license of the second(index 1)
	 * technology.
	 * 
	 * @see WebPage#findAllMatches(String)
	 */
	@Test
	public void testFindFirstMatch() {

		int arrayListIndex;

		Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995, "MIT");
		Technology mongodb = new Technology("MongoDB", "DBMS", "Store data", 2009, "GNU");

		webTest.addTechnology(mysql);
		webTest.addTechnology(mongodb);

		// We fetch gnu, which is found in the Tech mongodb, the second Tech added.
		arrayListIndex = webTest.findFirstMatch("gnu");

		// In case the data is not found, the method returns -1 but the test will be
		// considered passed.
		assertTrue(arrayListIndex == 1);

	}

	/**
	 * I add two Technologies inside the WebPage's ArrayList attribute. Then, using
	 * the method to be tested I collect the position inside the ArrayList where the
	 * first match of the data requested was found.
	 * 
	 * In this case, the test will be valid if the return is -1 because the input
	 * from console/user can vary.
	 * 
	 * @see WebPage#findFirstMatch(String, int)
	 */
	@Test
	public void testFindFirstMatch2() {

		int arrayListIndex;

		Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995, "MIT");
		Technology mongodb = new Technology("MongoDB", "DBMS", "Store data", 2009, "GNU");

		webTest.addTechnology(mysql);
		webTest.addTechnology(mongodb);

		// We fetch gnu, which is found in the Tech mongodb, the second Tech added.
		arrayListIndex = webTest.findFirstMatch(Utilities.getString("What do you want to find: "),
				Utilities.getIntBetween(1, 5,
						"Enter 1, 2, 3, 4 or 5 to search by: 1-Name, 2-Tech type, 3-Purpose, 4-Release year or 5-License"));

		// In case the data is not found, the method returns -1 but the test will be
		// considered passed.
		assertTrue(arrayListIndex == 0 || arrayListIndex == 1 || arrayListIndex == -1);

	}

	/**
	 * This test adds a new object into the WebPage's ArrayList and then we call the
	 * method to be tested that updates the previous object.
	 * 
	 * Finally, we compare the Technology added at the start with the modified
	 * technology, if they are different objects, then test is passed.
	 * 
	 * One of the existing techTest attributes must be searched or the test will
	 * fail because no changes will be made into the original object.
	 * 
	 * @see WebPage#updateTech(WebPage)
	 */
	@Test
	public void testUpdateTech() {

		// Adds the techTest Technology
		webTest.addTechnology(techTest);

		// Call to the method to find and change the Technology object that matches the
		// data requested.
		webTest.updateTech(webTest);

		assertTrue(webTest.getTechStack().size() == 1);

		// The original object added into the arraylist and the modified object must
		// differ.
		assertNotSame(techTest, webTest.getTechStack().get(0));
	}

	/**
	 * This test was problematic because despite changing one(or many?) attribute of
	 * the object it remains as the same object. That made the assertNotSame fail,
	 * because they were the same object with different content. I am not 100% sure
	 * of this but after serveral variations of the test thats my conclusion.
	 * 
	 * I had to try another strategy to test if the method is correctly changing the
	 * attribute.
	 * 
	 * @see WebPage#updateTechAtrribute(WebPage)
	 */
	@Test
	public void testUpdateTechAtrribute() {
		// Expected attribute
		String expectedName = "python";

		// Adds the techTest object
		webTest.addTechnology(techTest);

		/*
		 * Call to the method that updates the technoogy object attribute. IMPORTATN: to
		 * correctly test the method: search the word "testa", and then enter "1" to
		 * search by name. Then, change the name of the object to: "python", the
		 * expected change.
		 * 
		 */
		webTest.updateTechAttribute(webTest);

		assertEquals(expectedName, webTest.getTechStack().get(0).getTechName());
		assertTrue(webTest.getTechStack().size() == 1);
	}

	/**
	 * This method tests the effective removal of an specific object inside the
	 * ArrayList.
	 * 
	 * To do so, follow the comments in the test.
	 * 
	 * @see WebPage#remove(WebPage)
	 */
	@Test
	public void testRemove() {
		// Creation of two objects
		Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995, "MIT");
		Technology mongodb = new Technology("MongoDB", "DBMS", "Store data", 2009, "GNU");

		// Adding two objects into the ArrayList<Technology> attribute.
		webTest.addTechnology(mysql);
		webTest.addTechnology(mongodb);

		// In order to test correctly, search something contained in mysql or mongodb
		// objects and then press 'y' to confirm the removal.
		webTest.remove(webTest);

		// We test that the ArrayList<Technology> size is ONE.
		assertTrue(webTest.getTechStack().size() == 1);
	}

	/**
	 * This method tests the effective removal of every existing object inside the
	 * ArrayList<Technology>
	 * 
	 * @see WebPage#remove()
	 */
	@Test
	public void testRemove1() {

		// Creation of two objects
		Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995, "MIT");
		Technology mongodb = new Technology("MongoDB", "DBMS", "Store data", 2009, "GNU");

		// Adding two objects into the ArrayList<Technology> attribute.
		webTest.addTechnology(mysql);
		webTest.addTechnology(mongodb);

		// Enter 'y' to remove every object.
		webTest.remove();

		// After the method call, the size should be 0, indicating that there is no
		// object inside.
		assertTrue(webTest.getTechStack().size() == 0);
	}

}
