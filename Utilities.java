package practica2_MarcelinoGil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description This class contains the methods in charge of updating the data.
 * @author Marcelino Gil Nombela
 * @author Professor Carlos Rufiangel (method "areNumbers")
 * @version 1.0
 * @since 14/02/2023
 */
public class Utilities {

	/**
	 * <ul>
	 * <li>Displays a set of messages
	 * </ul>
	 */
	public static void mainMenu() {
		System.out.println("\u001B[107m" + "\u001B[32m" + "+--Marcelino Gil Nombela CRUD ArrayList System--+");
		System.out.print("\u001B[0m");
		System.out.println("\u001B[32m" + "1-Create");
		System.out.println("\u001B[32m" + "2-Find/read");
		System.out.println("\u001B[32m" + "3-Update/Modify");
		System.out.println("\u001B[32m" + "4-Remove");
		System.out.println("\u001B[32m" + "5-Exit program");
		System.out.println("\u001B[0m");

	}

	/**
	 * 
	 * Shows a message and receives an int from user input.
	 * 
	 * @deprecated
	 * @param message
	 * @return numberiNT
	 */
	public static int getInt(String message) {
		int numberInt;

		Scanner reader = new Scanner(System.in);
		System.out.println(message);
		numberInt = reader.nextInt();

		return numberInt;
	}

	/**
	 * Shows a message and receives a String from user. The only condition is the
	 * input must contain at least one character.
	 * 
	 * @param message Message shown.
	 * @return chainString The String retuned.
	 */
	public static String getString(String message) {

		String chainString;

		Scanner reader = new Scanner(System.in);

		do {
			System.out.println(message);

			chainString = reader.nextLine();
			if (chainString.isEmpty()) {
				System.out.println("Error. Invalid input.");
			}
		} while (chainString.isEmpty()); // To avoid entering a null value when pressing 'enter'.

		return chainString;
	}

	/**
	 * <ul>
	 * <li>Method developed in programming course to check if a string is made up of
	 * numbers.
	 * <li>The for loop keeps iterating through each character of the string
	 * received in the parameter until valid is true.
	 * <li>If during iterations one of the characters in the string is not a number,
	 * will give -1 and therefore valid becomes false and its returned.
	 * </ul>
	 *
	 * @param cadena The String that is going to be checked.
	 * @return boolean If the string contains no numbers, return false.
	 */
	public static boolean areNumbers(String cadena) {

		boolean valido = true;
		int longitud = cadena.length();
		int contador = 0;
		String numeros = "0123456789"; // también se puede comprobar si son número por codigo ASCII

		// LA MANERA CORRECTA DE BUSCAR UN VALOR DENTRO DE UN ARRAY O DE UNA CADENA

		while (contador < longitud && valido) {
			if (numeros.indexOf(cadena.charAt(contador)) == -1) {
				valido = false;
			} else {
				contador++;
			}
		}
		return valido;
	}

	/**
	 * <ul>
	 * <li>This function checks that the user input is a number between certain
	 * values.
	 * <li>The do/while loop will keep iterating until user enters a valid number.
	 * </ul>
	 * 
	 * @param min     Minimum valid number.
	 * @param max     Maximum valid number.
	 * @param message The message displayed to the user.
	 * 
	 * @return int The user int input.
	 */
	public static int getIntBetween(int min, int max, String message) {
		int selectorInt = 0; // Variable que se retornará posteriormente.
		String selectorString; // Dato String que el usuario introduce.
		boolean esValido = false; // Condición para salir del bucle de petición de dato válido.

		do {
			selectorString = Utilities.getString(message);
			System.out.println('\n');
			if (selectorString != null && !selectorString.isEmpty() && Utilities.areNumbers(selectorString)) {
				selectorInt = Integer.parseInt(selectorString);
				if (selectorInt >= min && selectorInt <= max) {
					esValido = true;
				} else {
					System.out.println("Error. Introduce a number between " + min + " and " + max + ".");
				}
			} else {
				System.out.println("Error. Write a valid number.");
			}
		} while (!esValido);

		return selectorInt;
	}

	
	/**
	 * <ul>
	 * <li>This method receives a String and returns the charAt(0) when the String
	 * is not null and its length iquals 1.
	 * <li>Apart from that, it also checks if the String is rather one of the two
	 * valid char options.
	 * <li>While some of the above conditions are not valid, while loop will keep
	 * asking for a valid input.
	 * </ul>
	 * 
	 * @param a       One of the two valid chars
	 * @param b       One of the two valid chars
	 * @param message The message displayed to the user.
	 * 
	 * @return selectorChar The
	 */
	public static char getCharMenu(char a, char b, String message) {
		char selectorChar = ' ';
		String selectorString;

		while (selectorChar != a && selectorChar != b) {
			System.out.println(message);
			selectorString = Utilities.getString("Enter '" + a + "' or '" + b + "'");
			if (selectorString != null && selectorString.length() == 1) {
				selectorChar = selectorString.charAt(0);
				if (selectorChar != a && selectorChar != b) {
					System.out.println("Error. Invalid character.");
				}
			} else {
				System.out.println("Error. Invalid input.");
			}
		}
		System.out.println('\n');
		return selectorChar;
	}
	
	
	public static ArrayList<Technology> getTechArrayList(){
		ArrayList<Technology> sampleTech = new ArrayList<Technology>();
		
		
		
		return sampleTech;
	}
	
	
	public static ArrayList<WebPage> webArrayList(int websNumber) {
		ArrayList<WebPage> webs = new ArrayList<WebPage>();
		ArrayList<Technology> techStack = new ArrayList<Technology>();
		
		for (int i = 0; i < websNumber; i++) {
			System.out.println("WebPage number " + (i + 1));
			System.out.print("Ingrese el nombre del objeto: ");
			webs.add(new WebPage(Utilities.getString("Introduce the name of the web: "),
					Utilities.getString("Introduce the URL: "),
					Utilities.getIntBetween(1, 10000000, "Introduce the budget of the project: "), techStack));
		}

		return webs;
	}

}
