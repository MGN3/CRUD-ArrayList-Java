package practica2_MarcelinoGil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Controller {
	/**
	 * When trying to create a system with CRUD functionalities, I found one
	 * important limitation of an ArrayList of objects: the Object's name have to be
	 * manually declared by the developer without the possibility to set its name
	 * from user interaction or from other inputs. And that is something a
	 * "HashMap<String, Object>" could do.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// JOptionPane.showMessageDialog(null, "Mensaje a mostrar");

		// WebPage blog = new WebPage(Utilities.getString("mgnblog"), "mgnblog.com",
		// 400, null);
		// WebPage.createTechnologies(2);

		// Selector for the main menu.
		int mainMenuChoice;

		// The selector for the sub menus.
		int menuChoice;

		// Another selector to confirm operations.
		char doSomethingElse;

		// Variable to save a specific index of the ArrayList<Technology>.
		int arrayListIndex;

		// Multipurpose boolean.
		boolean flag;

		// ------------------------------------------
		Technology foundTech;

		int attributeSelector;

		// The main object of this program: a webpage. Set null and without a specific
		// ArrayList<Technology>.
		WebPage ecommerce = new WebPage(null, null, 0);

		// This is the ArrayList of technologies that stores all the premade
		// technologies bellow.
		ArrayList<Technology> coreStack = new ArrayList<Technology>();

		// Premade Technologies.
		/*
		 * Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995,
		 * "MIT"); Technology mongodb = new Technology("MongoDB", "DBMS", "Store data",
		 * 0, "MIT123123"); Technology sqlserver = new Technology("SQL", "bbdd",
		 * "almacenar informacion", 0, null); Technology java = new Technology("SQL",
		 * "bbdd", "almacenar informacion", 0, null); Technology javascript = new
		 * Technology("SQL", "bbdd", "almacenar informacion", 0, null); Technology
		 * typescript = new Technology("SQL", "bbdd", "almacenar informacion", 0, null);
		 * Technology reactjs = new Technology("SQL", "bbdd", "almacenar informacion",
		 * 0, null); Technology nodejs = new Technology("SQL", "bbdd",
		 * "almacenar informacion", 0, null); Technology html = new Technology("SQL",
		 * "bbdd", "almacenar informacion", 0, null); Technology css = new
		 * Technology("SQL", "bbdd", "almacenar informacion", 0, null); Technology
		 * bootstrap = new Technology("SQL", "bbdd", "almacenar informacion", 0, null);
		 * Technology tailwindCss = new Technology("SQL", "bbdd",
		 * "almacenar informacion", 0, null); Technology springboot = new
		 * Technology("SQL", "bbdd", "almacenar informacion", 0, null);
		 */
		Technology mysql = new Technology("MySQL", "DBMS", "Store data", 1995, "MIT");
		Technology mongodb = new Technology("MongoDB", "DBMS", "Store data", 2009, "GNU");
		Technology sqlserver = new Technology("SQL Server", "DBMS", "Store data", 1989, "EULA");
		Technology java = new Technology("Java", "programming language", "application development", 1995, "GNU");
		Technology javascript = new Technology("JavaScript", "programming language", "web development", 1995,
				"Doesn't apply");
		Technology typescript = new Technology("TypeScript", "programming language", "web development", 2012, "Apache");
		Technology reactjs = new Technology("ReactJS", "JavaScript library", "web development", 2013, "MIT");
		Technology nodejs = new Technology("NodeJS", "JavaScript runtime", "web development", 2009, "MIT");
		Technology html = new Technology("HTML", "markup language for the web", "web development", 1993,
				"Doesn't apply");
		Technology css = new Technology("CSS", "cascading style sheets for the web", "web development", 1996,
				"Doesn't apply");
		Technology bootstrap = new Technology("Bootstrap", "CSS framework", "web development", 2011, "MIT");
		Technology tailwindCss = new Technology("Tailwind CSS", "CSS framework", "web development", 2017, "MIT");
		Technology springboot = new Technology("Spring Boot", "Java framework", "application development", 2002,
				"Apache");

		// The previous premade technologies being added into the coreStack ArrayList.
		coreStack.addAll(Arrays.asList(mysql, mongodb, sqlserver, java, javascript, typescript, reactjs, nodejs, html,
				css, bootstrap, tailwindCss, springboot));

		// System.out.println(webList.toString());

		// System.out.println(webList.get(0));

		// webList.toString().contains("bab");

		// webList.add(new WebPage(Utilities.getString("introduce Name "), null, 0,
		// prueba));

		// Before the CRUD menu appears, the WebPage main CRUD object must be created:
		ecommerce = new WebPage(Utilities.getString("Introduce Webpage name: "),
				Utilities.getString("Introduce the URL: "),
				Utilities.getIntBetween(1, 999999999, "Introduce the budget for the web project: "));

		/*
		 * This do/while loop will keep asking the user what to do until the user exits.
		 */
		do {

			// Menu with the availeable options.
			Utilities.mainMenu();

			// Returns the option chosen by the user.
			mainMenuChoice = Utilities.getIntBetween(1, 5, "Select your choice");

			/*
			 * This is the main switch. Each option (execept exit) contain a certain number
			 * of different functionalities.
			 */
			switch (mainMenuChoice) {

			case 1:
				// ------------ CREATE ------------

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 5,
						"Press '1' to create/rewrite the WebPage data. \nPress '2' to add a new tech. \nPress '3' to mostrar todo. \nPress '4' to add an existing tech. \nPress '5' to exit.");

				switch (menuChoice) {

				case 1:
					// Option to create/rewrite the main object of this CRUD: a webpage.
					// WebPage.
					ecommerce = new WebPage(Utilities.getString("Introduce Webpage name: "),
							Utilities.getString("Introduce the URL: "),
							Utilities.getIntBetween(1, 999999999, "Introduce the budget for the web project: "));

					// To include every premade Technology in the new WebPage enter y.
					doSomethingElse = Utilities.getCharMenu('y', 'n',
							"Do you want to add every premade Technology in the WebPage?");
					if (doSomethingElse == 'y') {
						ecommerce.setTechStack(coreStack);
					} else {
						System.out.println("The list of technologies will remain empty");
					}
					break;

				case 2:
					// To add a new Technology into WebPage's ArrayList of Technologies with user
					// imput for each Technology attribute.
					ecommerce.addTechnology();

					break;

				case 3:
					// Add one or more technologies into the WebPage ArrayList<Technology>.

					// Do-while loop to add another Technology until imput is 'n'
					do {
						// First, we show all the availeable premade Technolgies.
						ArrayListUtilities.showNames(coreStack);

						/*
						 * "flag" prevents the same technology from being added again. IMPORTANT: 1 is
						 * subtracted from Utilities.getIntBetween imput to match the proper position of
						 * the ArrayList.
						 */
						flag = ecommerce.getTechStack().contains(coreStack.get(arrayListIndex = Utilities
								.getIntBetween(1, 13, "Enter the number of the tech you want to add?") - 1));

						if (!flag) {
							System.out.println("The following Technology have been added: '"
									+ coreStack.get(arrayListIndex).getTechName());
							ecommerce.addTechnology(coreStack.get(arrayListIndex));

						} else {
							System.out.println("This Technology has already been added.");
						}

						doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to add another Technology?");

					} while (doSomethingElse != 'n');

					break;

				case 4:

					break;

				case 5:
					// Exits sub menu
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 2:
				// ------------ READ ------------

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 4,
						"Press '1' to find the first coincidence. \nPress '2' to find all the coincidences. \nPress '3' to show the whole database. \nPress '4' to exit");
				switch (menuChoice) {

				case 1:
					// Shows the first match found. Despite the fact that it returns an int, in this
					// case it is not necessary to collect it.
					ecommerce.findFirstMatch(Utilities.getString("Introduce the word you want to find"));
					break;

				case 2:
					// Shows all the matches found.
					ecommerce.findAllMatches(Utilities.getString("Introduce the word you want to find"));
					break;

				case 3:
					// Call to predefined toString method for the main WebPage object
					System.out.println(ecommerce.toString());
					break;

				case 4:
					// Search only a specific attribute of the Technology object. In this case,
					// .findFirstMatch return is nos usefull so no variable will collect it.
					ecommerce.findFirstMatch(Utilities.getString("What do you want to find: "), Utilities.getIntBetween(
							1, 5,
							"Enter 1, 2, 3, 4 or 5 to search by: 1-Name, 2-Tech type, 3-Purpose, 4-Release year or 5-License"));
					break;
///////////////AÑADIR EXIT OPTION
				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 3:
				// ------------ UPDATE ------------

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 3,
						"Press '1' to update a specific row. \nPress '2' to update all the matches for your data request\nPress '3' to exit.");
				switch (menuChoice) {

				case 1:
					// To overwrite Technology's attributes after a match.
					arrayListIndex = ecommerce
							.findFirstMatch(Utilities.getString("What do you want to find and update?"));

					// If the value of arrayListIndex is -1, no matches were found.
					if (arrayListIndex > -1) {
						ecommerce.getTechStack().set(arrayListIndex,
								new Technology(Utilities.getString("Set new name:"),
										Utilities.getString("Set new tech type:"),
										Utilities.getString("Set new purpose:"),
										Utilities.getIntBetween(1900, 2050, "Set new release year:"),
										Utilities.getString("Set new license:")));
					}
					break;

				case 2:
					// This option is meant to change a single attribute of the Technology where the
					// data requested has first been found.
					arrayListIndex = ecommerce.findFirstMatch(Utilities.getString("What do you want to find: "),
							attributeSelector = Utilities.getIntBetween(1, 5,
									"Enter 1, 2, 3, 4 or 5 to search by: 1-Name, 2-Tech type, 3-Purpose, 4-Release year or 5-License"));

					// If the value of arrayListIndex is -1, no matches were found.
					if (arrayListIndex > -1) {

						switch (attributeSelector) {

						case 1:
							ecommerce.getTechStack().get(arrayListIndex)
									.setTechName(Utilities.getString("Set new name:"));
							break;
						case 2:
							ecommerce.getTechStack().get(arrayListIndex)
									.setTechType(Utilities.getString("Set new tech type:"));
							break;
						case 3:
							ecommerce.getTechStack().get(arrayListIndex)
									.setPurpose(Utilities.getString("Set new purpose:"));
							break;
						case 4:
							ecommerce.getTechStack().get(arrayListIndex)
									.setReleaseYear(Utilities.getIntBetween(1900, 2050, "Set new release year:"));
							break;
						case 5:
							ecommerce.getTechStack().get(arrayListIndex)
									.setLicense(Utilities.getString("Set new license:"));
							break;
						default:
							System.out.println("Invalid option");
							break;
						}
					}
					break;

				case 3:
					// Exit option
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 4:
				// ------------ DELETE ------------

				// Request and return the desired option.
				menuChoice = Utilities.getIntBetween(1, 3,
						"Press '1' to remove a row. \nPress '2' to remove all the matches. \nPress '3' to remove every field. \nPress '4' to restart the database. \nPress '5' to exit.");
				switch (menuChoice) {

				case 1:
					// Removes a specific Technology out of the ArrayList.
					arrayListIndex = ecommerce
							.findFirstMatch(Utilities.getString("Which Technology do you want to find and remove?"));

					if (arrayListIndex > -1) {
						ecommerce.getTechStack().remove(arrayListIndex);
						System.out.println("The Technology have been removed");
					}
					break;

				case 2:
					// Removes all the Technologies objects inside the ArrayList.
					doSomethingElse = Utilities.getCharMenu('y', 'n',
							"Are you sure? This will remove every Technology from the list");
					if (doSomethingElse == 'y') {
						ecommerce.removeArrayList();
					}
					break;

				case 3:
					// Exit option

					break;
				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			// MAIN MENU SWITCH ENDS HERE
			}

		} while (mainMenuChoice != 5);
		System.out.println('\n');
		System.out.println("\u001B[31m" + "+--PROGRAM SHUTDOWN--+");
		System.out.println('\n');
		System.out.println('\n');
	}

}
