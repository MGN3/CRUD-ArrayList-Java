package practica2_MarcelinoGil;

import java.util.ArrayList;
import java.util.Arrays;

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

		// Selector for the main menu.
		int mainMenuChoice;

		// The selector for the sub menus.
		int menuChoice;

		// Another selector to confirm operations.
		char doSomethingElse;

		// Variable to save a specific index of the ArrayList<Technology>.
		// int arrayListIndex;

		// The main object of this program: a webpage. Set null and without a specific
		// ArrayList<Technology>.
		WebPage myWebsite = new WebPage(null, null, 0);

		// This is the ArrayList of technologies that stores all the premade
		// technologies bellow.
		ArrayList<Technology> coreStack = new ArrayList<Technology>();

		// Premade Technologies.
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

		// Before the CRUD menu appears, the WebPage main CRUD object must be created:
		System.out.println("\u001B[107m" + "\u001B[32m" + "Welcome, please introduce basic data about the Webpage");
		System.out.print("\u001B[0m");
		myWebsite = new WebPage(Utilities.getString("Introduce Webpage name: "),
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
				menuChoice = Utilities.getIntBetween(1, 4,
						"Press '1' to create/overwrite the WebPage data. \nPress '2' to add a new tech. \nPress '3' Show and add premade Techs. \nPress '4' to exit submenu.");

				switch (menuChoice) {

				case 1:
					// Option to create/overwrite the main object of this CRUD: a webpage.
					// It also gives the choice to include all the premade Technologies.
					myWebsite = new WebPage(Utilities.getString("Introduce Webpage name: "),
							Utilities.getString("Introduce the URL: "),
							Utilities.getIntBetween(1, 999999999, "Introduce the budget for the web project: "));

					// To include every premade Technology in the new WebPage enter y.
					doSomethingElse = Utilities.getCharMenu('y', 'n',
							"Do you want to add every premade Technology in the WebPage?");
					if (doSomethingElse == 'y') {
						myWebsite.setTechStack(coreStack);
					} else {
						System.out.println("The list of technologies will remain empty");
					}
					break;

				case 2:
					// To add a new Technology into WebPage's ArrayList of Technologies with user
					// input for each Technology attribute.
					myWebsite.addTechnology();

					break;

				case 3:
					// Adds one or more premade technologies into the WebPage ArrayList<Technology>.

					myWebsite.addPremadeTech(coreStack);

					break;

				case 4:
					// Exits sub menu
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another action.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 2:
				// ------------ READ ------------

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 5,
						"Press '1' to find the first match. \nPress '2' to find all the matches. \nPress '3' to show all the Web data. \nPress '4' to search by category. \\nPress '5' to exit submenu");
				switch (menuChoice) {

				case 1:
					// Shows the first match found. findFirstMatch returns and int but collecting it
					// is not usefull in this case.
					myWebsite.findFirstMatch(Utilities.getString("Introduce the word you want to find"));
					break;

				case 2:
					// Shows all the matches found.
					myWebsite.findAllMatches(Utilities.getString("Introduce the word you want to find"));
					break;

				case 3:
					// Call to predefined toString method for the main WebPage object
					System.out.println(myWebsite.toString());
					break;

				case 4:
					/*
					 * Same method but applying overload, in this case, the parameters are the data
					 * request and the category/attribute to fetch the requested data. The
					 * output/return from findFirstMatch is not needed so it wont be collected.
					 */
					myWebsite.findFirstMatch(Utilities.getString("What do you want to find: "), Utilities.getIntBetween(
							1, 5,
							"Enter 1, 2, 3, 4 or 5 to search by: 1-Name, 2-Tech type, 3-Purpose, 4-Release year or 5-License"));
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

			case 3:
				// ------------ UPDATE ------------

				// Requests and returns the desired option.
				menuChoice = Utilities.getIntBetween(1, 3,
						"Press '1' to update a Technology. \nPress '2' to update a specific data of the Technology. \nPress '3' to exit submenu.");
				switch (menuChoice) {

				case 1:
					// To overwrite Technology's attributes where the first match is found.

					/**
					 * Calling the method with the same object that is going to be used as a
					 * parameter seems wierd but it was an easier way to reuse the object method:
					 * ".findFirstMatch()".
					 */
					myWebsite.updateTech(myWebsite);

					break;

				case 2:
					/*
					 * This option changes a single attribute of the Technology where the data
					 * requested has first been found.
					 * 
					 */
					myWebsite.updateTechAttribute(myWebsite);

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
						"Press '1' to remove the first match found. \nPress '2' to remove the entire list of Technologies. \nPress '3' to exit submenu.");
				switch (menuChoice) {

				case 1:
					// Removes a specific Technology out of the ArrayList.
					myWebsite.remove(myWebsite);

					break;

				case 2:
					// Removes all the Technologies objects inside the ArrayList.
					doSomethingElse = Utilities.getCharMenu('y', 'n',
							"Are you sure? This will remove every Technology from the list");

					if (doSomethingElse == 'y') {
						myWebsite.remove();
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
